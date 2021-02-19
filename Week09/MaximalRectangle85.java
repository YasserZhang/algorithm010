//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle c
//ontaining only 1's and return its area.
//
// Example:
//
//
//Input:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//Output: 6
//
// Related Topics Array Hash Table Dynamic Programming Stack
// 👍 2955 👎 71


import java.util.ArrayDeque;
import java.util.Deque;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //还可以更优化，把二维变为一维

    /*    Success:
        Runtime:5 ms, faster than 83.43% of Java online submissions.
        Memory Usage:42 MB, less than 96.30% of Java online submissions.*/
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] f = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < m; ++i) f[0][i] = matrix[0][i] == '1' ? 1 : 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                f[i][j] = matrix[i][j] == '1' ? f[i-1][j] + 1 : 0;
            }
        }
        int maxArea = 0;
        for (int i = 0; i < n; ++i) {
            maxArea = Math.max(maxArea, largestRectangleArea(f[i]));
        }
        return maxArea;
    }

/*    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) {
                int idx = stack.removeLast();
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }
                maxArea = Math.max(maxArea, width * heights[idx]);
            }
            stack.addLast(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.removeLast();
            int width;
            if (stack.isEmpty()) {
                width = heights.length;
            } else {
                width = heights.length - stack.peekLast() - 1;
            }
            maxArea = Math.max(maxArea, width * heights[idx]);
        }
        return maxArea;
    }*/

    private int largestRectangleArea(int[] heights) {
        if (heights.length == 1) return heights[0];
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int idx = stack.removeLast();
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }
                maxArea = Math.max(maxArea, width * heights[idx]);
            }
            stack.addLast(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.removeLast();
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peekLast() - 1;
            maxArea = Math.max(maxArea, width * heights[idx]);
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
