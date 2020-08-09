//
//On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 i
//ndexed).
//
//Once you pay the cost, you can either climb one or two steps. You need to find
// minimum cost to reach the top of the floor, and you can either start from the s
//tep with index 0, or the step with index 1.
//
//
// Example 1:
//
//Input: cost = [10, 15, 20]
//Output: 15
//Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
//
//
//
// Example 2:
//
//Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//Output: 6
//Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[
//3].
//
//
//
// Note:
//
// cost will have a length in the range [2, 1000].
// Every cost[i] will be an integer in the range [0, 999].
//
// Related Topics Array Dynamic Programming
// 👍 2116 👎 473


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*    Success:
        Runtime:1 ms, faster than 89.30% of Java online submissions.
        Memory Usage:39.1 MB, less than 77.40% of Java online submissions.*/
    public int minCostClimbingStairs(int[] cost) {
        int f0 = 0, f1 = 0;
        for(int i = 0; i < cost.length; ++i) {
            int temp = Math.min(f0, f1) + cost[i];
            f0 = f1;
            f1 = temp;
        }
        return Math.min(f0, f1);
    }

    /**
     * 官方解答太差了，还不如这个评论写得清楚
     *
     *      * 注意，这个有点tricky
     *      * f(i) = V[i] + min(f(i-1), f(i-2))
     *      * f(i)的定义为，踩在i上的最小值，不是完成阶梯0, ..., i-1的最小值，完成阶梯i不一定要踩在i上
     *      * 要做到踩在i的话，之前要么踩在i-1，要么踩在i-2，取一个最小值就是min(f(i-1), f(i-2))，再加上当前值V[i]就是做到踩在i上的最小值
     *      * 注意，最后踩在i上或者i-1上，都是完成了这段阶梯，所以取f(n)和f(n-1)中的最小值
     *
     *
     */

/*    Success:
    Runtime:1 ms, faster than 89.30% of Java online submissions.
    Memory Usage:39.1 MB, less than 78.90% of Java online submissions.*/
/*    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) return 0;
        int[] f = new int[cost.length];
        f[0] = cost[0];
        f[1] = cost[1];
        for (int i = 2; i < f.length; ++i) {
            f[i] = Math.min(f[i-1], f[i-2]) + cost[i];
        }
        return Math.min(f[f.length-1], f[f.length-2]);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
