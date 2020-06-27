//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
//
//
//
//For example, given n = 3, a solution set is:
//
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking


import java.util.ArrayList;
import java.util.List;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*    Success:
        Runtime:0 ms, faster than 100.00% of Java online submissions.
        Memory Usage:39.5 MB, less than 67.01% of Java online submissions.*/
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(new StringBuilder(), 0, 0, n, res);
        return res;
    }

    private void helper(StringBuilder sb, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            helper(sb, left+1, right, n, res);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right < left) {
            sb.append(')');
            helper(sb, left, right+1, n, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

/*    Success:
    Runtime:2 ms, faster than 30.82% of Java online submissions.
    Memory Usage:38.9 MB, less than 99.83% of Java online submissions.*/
    //brute force
/*    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2*n], 0, combinations);
        return combinations;
    }

    private void generateAll(char[] cur, int pos, List<String> res) {
        if (cur.length == pos) {
            if (valid(cur)) {
                res.add(String.copyValueOf(cur));
            }
            return;
        }
        cur[pos] = '(';
        generateAll(cur, pos+1, res);
        cur[pos] = ')';
        generateAll(cur, pos+1, res);
    }

    private boolean valid(char[] cur) {
        int balance = 0;
        for (char c : cur) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance==0;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
