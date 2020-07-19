//Given a string containing just the characters '(' and ')', find the length of
//the longest valid (well-formed) parentheses substring.
//
// Example 1:
//
//
//Input: "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()"
//
//
// Example 2:
//
//
//Input: ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()"
//
// Related Topics String Dynamic Programming
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*    Success:
        Runtime:1 ms, faster than 100.00% of Java online submissions.
        Memory Usage:39.8 MB, less than 23.76% of Java online submissions.*/
    public int longestValidParentheses(String s) {
        int[] f = new int[s.length()];
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '(') continue;
            //then only consider when it is ')'
            if (s.charAt(i-1) == '(') {
                if (i - 2 >= 0) f[i] = f[i-2] + 2;
                else f[i] = 2;
            } else if (i - f[i-1] > 0 && s.charAt(i-f[i-1]-1) == '(') {
                f[i] = f[i-1] + 2;
                if (i - f[i-1] - 1 > 0) f[i] += f[i - f[i-1] - 2];
            }
        }
        int max = 0;
        for (int n : f) {
            max = Math.max(max, n);
        }
        return max;
    }
    //stack
/*    Success:
    Runtime:3 ms, faster than 47.68% of Java online submissions.
    Memory Usage:39.9 MB, less than 19.33% of Java online submissions.*/
/*    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); //add front sentinel
        int i;
        for (i = 0; i < s.length(); i++) {
            int p = stack.peek();
            if (s.charAt(i) == ')') {
                if (p >= 0 && s.charAt(p) == '(') stack.pop();
                else stack.push(i);
            }
            else {
                stack.push(i);
            }
        }
        stack.push(i);
        int max = 0;
        while(stack.size() > 1) {
            int p = stack.pop();
            max = Math.max(max, p - stack.peek() - 1);
        }
        return max;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
