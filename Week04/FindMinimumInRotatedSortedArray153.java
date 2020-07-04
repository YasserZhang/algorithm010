//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand.
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
// Find the minimum element.
//
// You may assume no duplicate exists in the array.
//
// Example 1:
//
//
//Input: [3,4,5,1,2]
//Output: 1
//
//
// Example 2:
//
//
//Input: [4,5,6,7,0,1,2]
//Output: 0
//
// Related Topics Array Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*    Success:
        Runtime:0 ms, faster than 100.00% of Java online submissions.
        Memory Usage:40 MB, less than 5.05% of Java online submissions.*/
    public int findMin(int[] nums) {
        //if no rotation
        if (nums[0] <= nums[nums.length - 1]) return nums[0];
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l + 1 < r) {
            mid = (l + r) / 2;
            if (nums[l] <= nums[mid]) l = mid;
            else r = mid;
        }
        return nums[r];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
