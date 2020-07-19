//Given a triangle, find the minimum path sum from top to bottom. Each step you
//may move to adjacent numbers on the row below.
//
// For example, given the following triangle
//
//
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
// Note:
//
// Bonus point if you are able to do this using only O(n) extra space, where n i
//s the total number of rows in the triangle.
// Related Topics Array Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*    Success:
        Runtime:2 ms, faster than 79.97% of Java online submissions.
        Memory Usage:41.1 MB, less than 6.23% of Java online submissions.*/
    int[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new int[n][n];
        return dfs(triangle,0,0);
    }
    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i+1 == triangle.size()) {
            memo[i][j] = triangle.get(i).get(j);
            return memo[i][j];
        }
        if (memo[i][j] != 0) return memo[i][j];
        int l = dfs(triangle, i+1, j);
        int r = dfs(triangle, i+1, j+1);
        memo[i][j] = Math.min(l, r) + triangle.get(i).get(j);
        return memo[i][j];
    }

/*    Success:
    Runtime:4 ms, faster than 39.08% of Java online submissions.
    Memory Usage:41.3 MB, less than 5.05% of Java online submissions.*/
/*    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n+1][n+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i+1][j], f[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return f[0][0];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
