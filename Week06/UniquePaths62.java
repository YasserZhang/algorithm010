//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below).
//
// The robot can only move either down or right at any point in time. The robot
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below).
//
// How many possible unique paths are there?
//
//
//Above is a 7 x 3 grid. How many possible unique paths are there?
//
//
// Example 1:
//
//
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-righ
//t corner:
//1. Right -> Right -> Down
//2. Right -> Down -> Right
//3. Down -> Right -> Right
//
//
// Example 2:
//
//
//Input: m = 7, n = 3
//Output: 28
//
//
//
// Constraints:
//
//
// 1 <= m, n <= 100
// It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
//
// Related Topics Array Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*    Success:
        Runtime:0 ms, faster than 100.00% of Java online submissions.
        Memory Usage:36.2 MB, less than 63.46% of Java online submissions.*/
    public int uniquePaths(int m, int n) {
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[j] += f[j-1];
            }
        }
        return f[n-1];
    }

/*    Success:
    Runtime:0 ms, faster than 100.00% of Java online submissions.
    Memory Usage:36.5 MB, less than 29.61% of Java online submissions.*/
/*    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
