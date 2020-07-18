//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed, the only constraint stopping you from r
//obbing each of them is that adjacent houses have security system connected and i
//t will automatically contact the police if two adjacent houses were broken into
//on the same night.
//
// Given a list of non-negative integers representing the amount of money of eac
//h house, determine the maximum amount of money you can rob tonight without alert
//ing the police.
//
//
// Example 1:
//
//
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4.
//
//
// Example 2:
//
//
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5
//(money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.
//
//
//
// Constraints:
//
//
// 0 <= nums.length <= 100
// 0 <= nums[i] <= 400
//
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*    Success:
        Runtime:0 ms, faster than 100.00% of Java online submissions.
        Memory Usage:36.5 MB, less than 89.75% of Java online submissions.*/
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] f = new int[2];
        f[1] = nums[0];
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            temp = f[1];
            f[1] = Math.max(f[1], f[0] + nums[i]);
            f[0] = temp;
        }
        return f[1];
    }

/*    Success:
    Runtime:0 ms, faster than 100.00% of Java online submissions.
    Memory Usage:38.6 MB, less than 11.86% of Java online submissions.*/
/*    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] f = new int[nums.length + 1];
        f[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            f[i] = Math.max(f[i-1],f[i-2] + nums[i-1]);
        }
        return f[nums.length];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
