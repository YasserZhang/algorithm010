//Given n non-negative integers a1, a2, ..., an , where each represents a point
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
// line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis for
//ms a container, such that the container contains the most water.
//
// Note: You may not slant the container and n is at least 2.
//
//
//
//
//
// The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In thi
//s case, the max area of water (blue section) the container can contain is 49.
//
//
//
// Example:
//
//
//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49 Related Topics Array Two Pointers


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*    Success:
        Runtime:5 ms, faster than 34.55% of Java online submissions.
        Memory Usage:46.3 MB, less than 5.08% of Java online submissions.*/
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while ( l < r) {
            max = Math.max(max, (r - l) * Math.min(height[l],height[r]));
            if (height[l] <= height[r]) l++;
            else r--;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
