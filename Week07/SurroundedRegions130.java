//Given a 2D board containing 'X' and 'O' (the letter O), capture all regions su
//rrounded by 'X'. 
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region
//. 
//
// Example: 
//
// 
//X X X X
//X O O X
//X X O X
//X O X X
// 
//
// After running your function, the board should be: 
//
// 
//X X X X
//X X X X
//X X X X
//X O X X
// 
//
// Explanation: 
//
// Surrounded regions shouldn’t be on the border, which means that any 'O' on th
//e border of the board are not flipped to 'X'. Any 'O' that is not on the border 
//and it is not connected to an 'O' on the border will be flipped to 'X'. Two cell
//s are connected if they are adjacent cells connected horizontally or vertically.
// 
// Related Topics Depth-first Search Breadth-first Search Union Find


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

/*    Success:
    Runtime:5 ms, faster than 14.44% of Java online submissions.
    Memory Usage:41.6 MB, less than 48.93% of Java online submissions.*/

    int[] parent;
    int count;
    private void init(char[][] board) {
        int m = board.length;
        int n= board[0].length;
        parent = new int[m*n + 1];
        count = m*n+1;
        for (int i = 0; i < parent.length; ++i) {
            parent[i] = i;
        }
    }

    private int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }

    private boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        init(board);
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'O') {
                    if (checkEdge(m, n, i, j)) {
                        union(i*n+j, m*n);
                    }
                    findAndUnion(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O' && !connected(i*n+j, m*n)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private boolean checkEdge(int m, int n, int i, int j) {
        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) return true;
        return false;
    }

    public void findAndUnion(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i >= 1 && board[i-1][j] == 'O') {
            union((i-1)*n + j, i*n + j);//, isEdge && checkEdge(board, i-1, j)); //up
        }
        if (i <= m - 2 && board[i+1][j] == 'O') {
            union((i+1)*n + j, i*n + j); //, isEdge && checkEdge(board, i+1, j)); //down
        }
        if (j >= 1 && board[i][j-1] == 'O') {
            union(i*n + j - 1, i*n + j); //, isEdge && checkEdge(board,i,j-1)); //left
        }
        if (j <= n - 2 && board[i][j+1] == 'O') {
            union(i*n + j + 1, i*n + j); //, isEdge && checkEdge(board, i, j+1)); // right
        }
    }

    //failed attempt
/*    Wrong Answer:
    input:[["O","X","X","X","X","X","O","O"],["O","O","O","X","X","X","X","O"],["X","X","X","X","O","O","O","O"],["X","O","X","O","O","X","X","X"],["O","X","O","X","X","X","O","O"],["O","X","X","O","O","X","X","O"],["O","X","O","X","X","X","O","O"],["O","X","X","X","X","O","X","X"]]
    Output:[["O","X","X","X","X","X","O","O"],["O","O","O","X","X","X","X","O"],["X","X","X","X","X","X","X","O"],["X","X","X","X","X","X","X","X"],["O","X","X","X","X","X","O","O"],["O","X","X","X","X","X","X","O"],["O","X","X","X","X","X","O","O"],["O","X","X","X","X","O","X","X"]]
    Expected:[["O","X","X","X","X","X","O","O"],["O","O","O","X","X","X","X","O"],["X","X","X","X","O","O","O","O"],["X","X","X","O","O","X","X","X"],["O","X","X","X","X","X","O","O"],["O","X","X","X","X","X","X","O"],["O","X","X","X","X","X","O","O"],["O","X","X","X","X","O","X","X"]]*/
    /*
    class Node {
        int pos;
        char mark;
        Node(int pos, char mark) {
            this.pos = pos;
            this.mark = mark;
        }
    }
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        UnionFind uf = new UnionFind(board);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') uf.findAndUnion(board, i, j);
            }
        }
        uf.fill(board);
    }
    
    class UnionFind {
        private int[] parent;
        private int count;
        private Node[] nodes;
        public UnionFind(char[][] board) {
            int m = board.length;
            int n = board[0].length;
            parent = new int[m*n];
            nodes = new Node[m*n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') {
                        parent[i*n+j] = i*n+j;
                        nodes[i*n+j] = new Node(i*n+j, 'O');
                        count++;
                    }
                }
            }
        }

        private int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        private void union(int p, int q) { //, boolean isEdge) {
            int rootP = find(p);
            int rootQ = find(q);
            if(nodes[p].mark == 'O') nodes[rootP].mark = 'O';
            if(nodes[q].mark == 'O') nodes[rootQ].mark = 'O';
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }

        public void findAndUnion(char[][] board, int i, int j) {
            int m = board.length;
            int n = board[0].length;
            checkEdge(board, i, j);
            if (i >= 1 && board[i-1][j] == 'O') {
                checkEdge(board, i-1, j);
                union((i-1)*n + j, i*n + j);//, isEdge && checkEdge(board, i-1, j)); //up
            }
            if (i <= m - 2 && board[i+1][j] == 'O') {
                checkEdge(board, i+1, j);
                union((i+1)*n + j, i*n + j); //, isEdge && checkEdge(board, i+1, j)); //down
            }
            if (j >= 1 && board[i][j-1] == 'O') {
                checkEdge(board,i,j-1);
                union(i*n + j - 1, i*n + j); //, isEdge && checkEdge(board,i,j-1)); //left
            }
            if (j <= n - 2 && board[i][j+1] == 'O') {
                checkEdge(board, i, j+1);
                union(i*n + j + 1, i*n + j); //, isEdge && checkEdge(board, i, j+1)); // right
            }
        }

        public void fill(char[][] board) {
            int n = board[0].length;
            for (int i = 0; i < nodes.length; i++) {
                Node node = nodes[i];
                if (node == null) continue;
                if (node.mark == 'O') continue;
                int root = find(node.pos);
                if (nodes[root].mark == 'X') board[i/n][i%n] = 'X';
            }
        }

        public void checkEdge(char[][] board, int i, int j) {
            int m = board.length;
            int n = board[0].length;
            //if not edge, mark it as X
            if (i >= 1 && i <= m -2 && j >= 1 && j <= n - 2) {

                nodes[i*n+j].mark = 'X';
            }
        }
    }
*/
}
//leetcode submit region end(Prohibit modification and deletion)
