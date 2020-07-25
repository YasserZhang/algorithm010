//Given a 2d grid map of '1's (land) and '0's (water), count the number of islan
//ds. An island is surrounded by water and is formed by connecting adjacent lands
//horizontally or vertically. You may assume all four edges of the grid are all su
//rrounded by water.
//
//
// Example 1:
//
//
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
//
//
// Example 2:
//
//
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
//
// Related Topics Depth-first Search Breadth-first Search Union Find


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    //adding rank doesn't change much, this indicates most connected components in the test set are relatively similar in size.
/*    Success:
    Runtime:3 ms, faster than 37.98% of Java online submissions.
    Memory Usage:42.1 MB, less than 34.17% of Java online submissions.*/
    int[] parent;
    byte[] rank;
    int count;
    private void init(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        count = 0;
        parent = new int[m*n];
        rank = new byte[m*n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    parent[i*n + j] = i * n + j;
                    rank[i*n + j] = 0;
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

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = parent[rootP];
            rank[rootP]++;
        } else {
            parent[rootP] = rootQ;
            rank[rootQ]++;
        }
        count--;
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        init(grid);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    findAndUnion(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void findAndUnion(char[][] grid, int[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        //up
        if (i >= 1 && grid[i-1][j] == '1') {
            union((i-1)*n + j, i*n + j);
        }
        // down
        if (i <= m - 2 && grid[i+1][j] == '1') {
            union((i+1)*n + j, i*n + j);
        }
        // left
        if (j >= 1 && grid[i][j-1] == '1') {
            union(i*n +j - 1, i*n + j);
        }
        //right
        if (j <= n - 2 && grid[i][j+1] == '1') {
            union(i*n + j + 1, i*n + j);
        }
    }


/*    Success:
    Runtime:3 ms, faster than 37.98% of Java online submissions.
    Memory Usage:42 MB, less than 47.24% of Java online submissions.*/
/*    int[] parent;
    int count;
    private void init(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        count = 0;
        parent = new int[m*n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    parent[i*n + j] = i * n + j;
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

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        init(grid);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    findAndUnion(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void findAndUnion(char[][] grid, int[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        //up
        if (i >= 1 && grid[i-1][j] == '1') {
            union((i-1)*n + j, i*n + j);
        }
        // down
        if (i <= m - 2 && grid[i+1][j] == '1') {
            union((i+1)*n + j, i*n + j);
        }
        // left
        if (j >= 1 && grid[i][j-1] == '1') {
            union(i*n +j - 1, i*n + j);
        }
        //right
        if (j <= n - 2 && grid[i][j+1] == '1') {
            union(i*n + j + 1, i*n + j);
        }
    }
    */
/*    Success:
    Runtime:2 ms, faster than 65.29% of Java online submissions.
    Memory Usage:45 MB, less than 5.02% of Java online submissions.*/
/*    private int count;
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int[][] visited, int i, int j) {
        if (grid[i][j] == '0' || visited[i][j] == 1) return;
        visited[i][j] = 1;
        //up
        if (i >= 1) dfs(grid, visited, i - 1, j);
        // down
        if (i <= grid.length - 2) dfs(grid, visited, i + 1, j);
        // left
        if (j >= 1) dfs(grid, visited, i, j - 1);
        // right
        if (j <= grid[0].length - 2) dfs(grid, visited, i, j + 1);
    }*/


    //如果在进入下一层迭代之前做出判断，这样可以提高性能。
/*    Success:
    Runtime:1 ms, faster than 99.95% of Java online submissions.
    Memory Usage:42.2 MB, less than 24.31% of Java online submissions.*/
/*    private int count;
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int[][] visited, int i, int j) {
        //if (grid[i][j] == '0') return;
        visited[i][j] = 1;
        //up
        if (i >= 1 && grid[i-1][j] == '1' && visited[i-1][j] == 0) dfs(grid, visited, i - 1, j);
        // down
        if (i <= grid.length - 2 && grid[i+1][j] == '1' && visited[i+1][j] == 0) dfs(grid, visited, i + 1, j);
        // left
        if (j >= 1 && grid[i][j-1] == '1' && visited[i][j-1] == 0) dfs(grid, visited, i, j - 1);
        // right
        if (j <= grid[0].length - 2 && grid[i][j+1] == '1' && visited[i][j+1] == 0) dfs(grid, visited, i, j + 1);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
