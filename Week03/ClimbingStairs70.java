//You are climbing a stair case. It takes n steps to reach to the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top?
//
// Note: Given n will be a positive integer.
//
// Example 1:
//
//
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//
//
// Example 2:
//
//
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
//
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*    Success:
        Runtime:0 ms, faster than 100.00% of Java online submissions.
        Memory Usage:38.5 MB, less than 5.01% of Java online submissions.*/
    public int climbStairs(int n) {
        int[][] q = {{1,1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        c[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        c[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        c[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        c[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];
        return c;
    }

/*    Success:
    Runtime:0 ms, faster than 100.00% of Java online submissions.
    Memory Usage:36.2 MB, less than 56.72% of Java online submissions.*/
/*    public int climbStairs(int n) {
        int[] f = new int[n+1];
        f[0] = f[1] = 1;
        for (int i = 2; i < n + 1; ++i) {
            f[i] = f[i-2] + f[i-1];
        }
        return f[n];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
