//Given a string s, find the longest palindromic substring in s. You may assume
//that the maximum length of s is 1000.
//
// Example 1:
//
//
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//
//
// Example 2:
//
//
//Input: "cbbd"
//Output: "bb"
//
// Related Topics String Dynamic Programming
// 👍 7358 👎 554


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*    Success:
        Runtime:23 ms, faster than 86.44% of Java online submissions.
        Memory Usage:39.4 MB, less than 67.66% of Java online submissions.*/
    public String longestPalindrome(String s) {
        if (s.length() == 0) return s;
        int start = 0, end = 0;
        int[] border1;
        int[] border2;
        for (int i=0; i < s.length(); ++i) {
            border1 = expandAroundCenter(s, i, i);
            border2 = expandAroundCenter(s, i, i+1);
            if (border1[1] - border1[0] > end - start) {
                start = border1[0];
                end = border1[1];
            }
            if (border2[1] - border2[0] > end - start) {
                start = border2[0];
                end = border2[1];
            }
        }
        return s.substring(start, end+1);
    }

    private int[] expandAroundCenter(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            --start;
            ++end;
        }
        return new int[] {++start, --end};
    }

}
//leetcode submit region end(Prohibit modification and deletion)
