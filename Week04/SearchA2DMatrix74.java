//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties:
//
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previou
//s row.
//
//
// Example 1:
//
//
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//Output: true
//
//
// Example 2:
//
//
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//Output: false
// Related Topics Array Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //官方
/*    Success:
    Runtime:0 ms, faster than 100.00% of Java online submissions.
    Memory Usage:42.1 MB, less than 7.33% of Java online submissions.*/
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }

/*    Success:
    Runtime:1 ms, faster than 13.15% of Java online submissions.
    Memory Usage:41.7 MB, less than 14.76% of Java online submissions.*/
/*    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int l = 0;
        int r = matrix.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] < target) l = mid + 1;
            else r = mid - 1;
        }
        int level;
        if (matrix[mid][0] <= target) level = mid;
        else if (mid == 0) return false;
        else level = mid - 1;
        l = 0;
        r = matrix[0].length - 1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (matrix[level][mid] == target) return true;
            if (matrix[level][mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
