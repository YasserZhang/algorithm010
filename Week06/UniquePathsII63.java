//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below).
//
// The robot can only move either down or right at any point in time. The robot
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below).
//
// Now consider if some obstacles are added to the grids. How many unique paths
//would there be?
//
//
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
// Note: m and n will be at most 100.
//
// Example 1:
//
//
//Input:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//Output: 2
//Explanation:
//There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
//
// Related Topics Array Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] f = new int[n];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) { //说明此时在障碍物上，所有计算归零，跳过后面步骤
                    f[j] = 0;
                    continue;
                }
                //obstacleGrid[i][j-1] == 0 不是必须的，因为之前的if判断已经将【i】【j-1】这个位置的计算记录做了更新，但依然加上它
                //是为了避免增加一次+=的操作。
                //我专门针对加与不加这个判断条件进行了试验，如果加，每次提交代码基本都是faster than 100%；
                // 如果不加，则表现不是很稳定，有时只有30%多，而有时候能干到100%
                if (j >= 1 && obstacleGrid[i][j-1] == 0) f[j] += f[j-1];
            }
        }
        return f[n-1];
    }
/*    Success:
    Runtime:0 ms, faster than 100.00% of Java online submissions.
    Memory Usage:39.1 MB, less than 24.98% of Java online submissions.*/
/*    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;
            f[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
