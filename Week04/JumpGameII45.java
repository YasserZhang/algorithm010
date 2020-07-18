//Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array.
//
// Each element in the array represents your maximum jump length at that positio
//n.
//
// Your goal is to reach the last index in the minimum number of jumps.
//
// Example:
//
//
//Input: [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2.
//    Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
// Note:
//
// You can assume that you can always reach the last index.
// Related Topics Array Greedy


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //greedy 2, O(n)
/*    Success:
    Runtime:2 ms, faster than 56.84% of Java online submissions.
    Memory Usage:43.7 MB, less than 8.85% of Java online submissions.*/
    public int jump(int[] nums) {
        int jumpUpperBound = 0;
        int maxReachForThisJump = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            maxReachForThisJump = Math.max(maxReachForThisJump, i + nums[i]);
            if (i == jumpUpperBound) {
                jumpUpperBound = maxReachForThisJump;
                steps++;
            }
        }
        return steps;
    }

    //贪心算法
/*    Success:
    Runtime:241 ms, faster than 24.35% of Java online submissions.
    Memory Usage:41.5 MB, less than 46.06% of Java online submissions.*/
/*    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; ++i) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
