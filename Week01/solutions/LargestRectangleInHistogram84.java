//Given n non-negative integers representing the histogram's bar height where th
//e width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//
//
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3
//].
//
//
//
//
//The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//
//
// Example:
//
//
//Input: [2,1,5,6,2,3]
//Output: 10
//
// Related Topics Array Stack


import java.util.ArrayDeque;
import java.util.ArrayDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //sentinel
    //slower than the previous solution as it needs to copy the array.
/*    Success:
    Runtime:15 ms, faster than 36.28% of Java online submissions.
    Memory Usage:45.7 MB, less than 5.01% of Java online submissions.*/
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        //create a new array including two sentinel values at the two ends.
        int[] h = new int[heights.length + 2];
        //fill heights into the new array
        for (int i = 0; i < heights.length; ++i) {
            h[i+1] = heights[i];
        }
        //System.arraycopy(heights, 0, h, 1, heights.length);
        //use monotone stack, only push a column when it is higher than the top one on the stack.
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < h.length; ++i) {
            while (!stack.isEmpty() && h[stack.peekLast()] > h[i]) {
                int idx = stack.removeLast();
                //if the previous colum's height is equal to current one, the we can pop it out to expand the width.
                //this can save time when there are many consecutive columns with equal heights
                while (h[stack.peekLast()] == h[idx]) {
                    stack.removeLast();
                }
                int prevIdx = stack.peekLast();
                area = Math.max(area, (i - prevIdx - 1) * h[idx]);
            }
            stack.addLast(i);
        }
        return area;
    }
/*    Success:
    Runtime:10 ms, faster than 47.28% of Java online submissions.
    Memory Usage:45.4 MB, less than 6.26% of Java online submissions.*/
/*    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        int i;
        for (i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int idx = stack.removeLast();
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    int prevIdx = stack.peekLast();
                    width = i - prevIdx - 1;
                }
                area = Math.max(area, width * heights[idx]);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.removeLast();
            int width;
            if (stack.isEmpty()) {
                width = i;
            } else {
                int prevIdx = stack.peekLast();
                width = i - prevIdx - 1;
            }
            area = Math.max(area, width * heights[idx]);
        }
        return area;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
