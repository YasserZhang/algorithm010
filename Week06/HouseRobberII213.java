//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed. All houses at this place are arranged i
//n a circle. That means the first house is the neighbor of the last one. Meanwhil
//e, adjacent houses have security system connected and it will automatically cont
//act the police if two adjacent houses were broken into on the same night.
//
// Given a list of non-negative integers representing the amount of money of eac
//h house, determine the maximum amount of money you can rob tonight without alert
//ing the police.
//
// Example 1:
//
//
//Input: [2,3,2]
//Output: 3
//Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money =
//2),
//             because they are adjacent houses.
//
//
// Example 2:
//
//
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4.
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*    Success:
        Runtime:0 ms, faster than 100.00% of Java online submissions.
        Memory Usage:37.1 MB, less than 36.72% of Java online submissions.*/
    public int rob(int[] nums) {
        if (nums.length <= 3) return res(nums);
        return Math.max(subRob(nums, 0, nums.length - 1), subRob(nums, 1, nums.length));


    }
    private int res(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }

    public int subRob(int[] nums, int s, int e) {
        int first = 0;
        int second = nums[s];
        int temp = 0;
        for (int i = s + 1; i < e; ++i) {
            temp = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }
        return second;
    }

    //wrong solution:
    //本以为掐头去尾后的数组的最大结果可以作为base来计算加头和加尾分别的结果
    //但是不行，没有考虑到这个base无法和头兼容，因为它是包含与头相邻的次头的结果。下面的例子能够说明问题。
/*    Wrong Answer:
    input:[1,2,1,0]
    Output:3
    Expected:2
    stdout:*/

/*    public int rob(int[] nums) {
        if (nums.length <= 3) return res(nums);
        int first = 0;
        int second = nums[1];
        int temp = 0;
        for (int i = 2; i < nums.length - 1; i++) {
            temp = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }
        return Math.max(first + nums[nums.length - 1], second + nums[0]);
    }

    private int res(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
