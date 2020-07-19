//Given a 2D binary matrix filled with 0's and 1's, find the largest square cont
//aining only 1's and return its area.
//
// Example:
//
//
//Input:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//Output: 4
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    每找到一个1，都去查询它的左斜上角是否也是1，如果是，获取其square的边长edge, 即f[i-1][j-1]，然后遍历目前位置的左边长和右边长在edge+1的范围
    内逐级确定是否都是1。有多少个1，就说明所在位置对应的square的边长有多长。
    这个的算法的时间复杂度应该是O（mn*min（m,n））,不知道为啥能获得这么高的runtime性能。
     */
/*    Success:
    Runtime:3 ms, faster than 98.54% of Java online submissions.
    Memory Usage:42.6 MB, less than 72.58% of Java online submissions.*/
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] f = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == '1') {
                f[i][0] = 1;
                max = Math.max(max, f[i][0]);
            }
        }
        for (int j = 0; j < matrix[0].length; ++j) {
            if (matrix[0][j] == '1') {
                f[0][j] = 1;
                max = Math.max(max, f[0][j]);
            }
        }
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][j] == '1') {
                    f[i][j] = 1;
                    if (matrix[i-1][j-1] == '1') {
                        int edge = f[i-1][j-1] + 1;
                        for (int k = 1; k < edge; k++) {
                            if (matrix[i-k][j] == '1' && matrix[i][j-k] == '1') f[i][j]++;
                            else break;
                        }
                    }
                    max = Math.max(max, f[i][j]);
                }
            }
        }
        return max*max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
