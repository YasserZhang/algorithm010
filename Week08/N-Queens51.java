//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other.
//
//
//
// Given an integer n, return all distinct solutions to the n-queens puzzle.
//
// Each solution contains a distinct board configuration of the n-queens' placem
//ent, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
// Example:
//
//
//Input: 4
//Output: [
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as show
//n above.
//
// Related Topics Backtracking


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

/*    Success:
    Runtime:3 ms, faster than 82.14% of Java online submissions.
    Memory Usage:39.3 MB, less than 85.89% of Java online submissions.*/
/*    int[] hills;
    int[] rows;
    int[] dales;
    List<List<String>> result = new ArrayList<>();
    int[] queens;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        hills = new int[2*n - 1];
        rows = new int[n];
        dales = new int[2*n - 1];
        queens = new int[n];
        backtrack(0);
        return result;
    }

    private void backtrack(int row) {
        for (int col = 0; col < n; ++col) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                if (row + 1 == n) addSolution();
                else backtrack(row+1);
                removeQueen(row, col);
            }
        }
    }

    private void addSolution() {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < queens.length; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; ++j) {
                if (j == queens[i]) sb.append("Q");
                else sb.append(".");
            }
            res.add(sb.toString());
        }
        result.add(res);
    }

    private boolean isNotUnderAttack(int row, int col) {
        int num = rows[col] + hills[row + col] + dales[row - col + n - 1];
        return num == 0;
    }
    private void placeQueen(int row, int col) {
        rows[col] = 1;
        hills[row + col] = 1;
        dales[row - col + n - 1] = 1;
        queens[row] = col;
    }

    private void removeQueen(int row, int col) {
        rows[col] = 0;
        hills[row + col] = 0;
        dales[row - col + n - 1] = 0;
    }*/

/*    Success:
    Runtime:3 ms, faster than 82.14% of Java online submissions.
    Memory Usage:39.5 MB, less than 59.75% of Java online submissions.*/
/*    int rows[];
    int hills[];
    int dales[];
    int n;
    List<List<String>> output = new ArrayList<>();
    int queens[];

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        hills = new int[2*n - 1];
        dales = new int[2*n - 1];
        queens = new int[n];
        backtrack(0);
        return output;
    }

    private void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                if (row + 1 == n) addSolution();
                else backtrack(row+1);
                removeQueen(row, col);
            }
        }
    }

    private boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + hills[row - col + n - 1] + dales[row + col];
        return (res == 0) ? true : false;
    }

    private void placeQueen(int row, int col) {
        //第row排的queen的col位置
        queens[row] = col;
        rows[col] = 1;
        hills[row - col + n - 1] = 1;
        dales[row + col] = 1;
    }

    private void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        hills[row - col + n - 1] = 0;
        dales[row + col] = 0;
    }

    private void addSolution() {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; ++j) sb.append(".");
            sb.append("Q");
            for (int j = col+1; j < n; ++j) sb.append(".");
            solution.add(sb.toString());
        }
        output.add(solution);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
