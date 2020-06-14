//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it is able to trap after raining.
//
//
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
//this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos
// for contributing this image!
//
// Example:
//
//
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
// Related Topics Array Two Pointers Stack


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        int current = 0;
        while (current < height.length) {
            while (!st.empty() && height[current] > height[st.peek()]) {
                int top = st.peek();
                st.pop();
                if (st.empty()) {
                    break;
                }
                int distance = current - st.peek() - 1;
                int boundedHeight = Math.min(height[current], height[st.peek()]) - height[top];
                ans += distance * boundedHeight;
            }
            st.push(current++);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
