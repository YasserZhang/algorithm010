//
//There are N students in a class. Some of them are friends, while some are not.
// Their friendship is transitive in nature. For example, if A is a direct friend
//of B, and B is a direct friend of C, then A is an indirect friend of C. And we d
//efined a friend circle is a group of students who are direct or indirect friends
//.
//
//
//
//Given a N*N matrix M representing the friend relationship between students in
//the class. If M[i][j] = 1, then the ith and jth students are direct friends with
// each other, otherwise not. And you have to output the total number of friend ci
//rcles among all the students.
//
//
// Example 1:
//
//Input:
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//Output: 2
//Explanation:The 0th and 1st students are direct friends, so they are in a frie
//nd circle. The 2nd student himself is in a friend circle. So return 2.
//
//
//
// Example 2:
//
//Input:
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//Output: 1
//Explanation:The 0th and 1st students are direct friends, the 1st and 2nd stude
//nts are direct friends, so the 0th and 2nd students are indirect friends. All of
// them are in the same friend circle, so return 1.
//
//
//
//
// Note:
//
// N is in range [1,200].
// M[i][i] = 1 for all students.
// If M[i][j] = 1, then M[j][i] = 1.
//
// Related Topics Depth-first Search Union Find


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //adding path compression, performance increased, but just a bit. complexity O(n^3)
/*    Success:
    Runtime:4 ms, faster than 31.23% of Java online submissions.
    Memory Usage:51.4 MB, less than 5.04% of Java online submissions.*/
    int[] parent;
    int count;
    private void init(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    private int find(int p) {
        int child = p;
        while (p != parent[p]) {
            p = parent[p];
        }
        while (child != p) {
            int temp = child;
            child = parent[child];
            parent[temp] = p;
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

    public int findCircleNum(int[][] M) {
        init(M.length);
        for (int i = 0; i < M.length; ++i) {
            for (int j = 0; j < M.length; ++j) {
                if (M[i][j] == 1) union(i, j);
            }
        }
        return count;
    }


/*    Success:
    Runtime:8 ms, faster than 13.46% of Java online submissions.
    Memory Usage:51.4 MB, less than 5.04% of Java online submissions.*/

/*
    int[] parent;
    int count;
    private void init(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    private int find(int p) {
        while (p != parent[p]) {
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

    public int findCircleNum(int[][] M) {
        init(M.length);
        for (int i = 0; i < M.length; ++i) {
            for (int j = 0; j < M.length; ++j) {
                if (M[i][j] == 1) union(i, j);
            }
        }
        return count;
    }
*/

//O(n^2)
/*    Success:
    Runtime:1 ms, faster than 83.56% of Java online submissions.
    Memory Usage:40.3 MB, less than 39.80% of Java online submissions.*/
/*    private int count;
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
        count = 0;
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; ++i) {
            if (visited[i] == 1) continue;
            dfs(M, visited, i);
            count++;
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int idx) {
        if (visited[idx] == 1) return;
        visited[idx] = 1;
        for (int i = 0; i < M.length; ++i) {
            if (M[idx][i] == 0) continue;
            if (visited[i] == 0) dfs(M, visited, i);
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
