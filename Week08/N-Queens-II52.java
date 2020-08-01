//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other.
//
//
//
// Given an integer n, return the number of distinct solutions to the n-queens p
//uzzle.
//
// Example:
//
//
//Input: 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown
//below.
//[
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//
// Related Topics Backtracking


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*    Success:
        Runtime:0 ms, faster than 100.00% of Java online submissions.
        Memory Usage:36.3 MB, less than 33.83% of Java online submissions.*/
    public int totalNQueens(int n) {
        return backtrack(0, 0, 0, 0, 0, n);
    }

    public int backtrack(int row, int hills, int next_row, int dales, int count, int n) {
        int columns = (1 << n) - 1;
        if (row == n) count ++;
        else {
            int free_columns = columns & ~(hills | next_row | dales);
            while (free_columns != 0) {
                int curr_column = free_columns & -free_columns;
                free_columns ^= curr_column;
                count = backtrack(row + 1,
                        (hills | curr_column) << 1,
                        next_row | curr_column,
                        (dales | curr_column) >> 1, count, n);
            }
        }
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
