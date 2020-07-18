//Given an array nums, write a function to move all 0's to the end of it while m
//aintaining the relative order of the non-zero elements.
//
// Example:
//
//
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0]
//
// Note:
//
//
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.
// Related Topics Array Two Pointers


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*    Success:
        Runtime:0 ms, faster than 100.00% of Java online submissions.
        Memory Usage:39.8 MB, less than 58.69% of Java online submissions.*/
    public void moveZeroes(int[] nums) {
        int lastZeroFoundAt = 0;
        int p = 0;
        while (p < nums.length) {
            if (nums[p] != 0) {
                nums[lastZeroFoundAt++] = nums[p];
            }
            p++;
        }
        for (int i = lastZeroFoundAt; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }

    //Wrong Solution
/*    public void moveZeroes(int[] nums) {
        int zero = 0;
        int p = 0;
        while (p < nums.length - 1 && zero < nums.length - 1 ) {
            if (nums[zero] != 0) zero++;
            if (nums[p] == 0) p++;
            if (nums[zero] == 0 && nums[p] != 0) {
                nums[zero] = nums[p];
                nums[p] = 0;
            }
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
