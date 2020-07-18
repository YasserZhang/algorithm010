//Given two strings text1 and text2, return the length of their longest common s
//ubsequence.
//
// A subsequence of a string is a new string generated from the original string
//with some characters(can be none) deleted without changing the relative order of
// the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is
// not). A common subsequence of two strings is a subsequence that is common to bo
//th strings.
//
//
//
// If there is no common subsequence, return 0.
//
//
// Example 1:
//
//
//Input: text1 = "abcde", text2 = "ace"
//Output: 3
//Explanation: The longest common subsequence is "ace" and its length is 3.
//
//
// Example 2:
//
//
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
//
//
// Example 3:
//
//
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
//
//
//
// Constraints:
//
//
// 1 <= text1.length <= 1000
// 1 <= text2.length <= 1000
// The input strings consist of lowercase English characters only.
//
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*    Success:
        Runtime:22 ms, faster than 21.90% of Java online submissions.
        Memory Usage:39.1 MB, less than 92.39% of Java online submissions.*/
    public int longestCommonSubsequence(String text1, String text2) {
        int[] f = new int[text2.length()+1];
        int temp = 0;
        for (int i = 1; i <= text1.length(); ++i) {
            int last = 0;
            for (int j = 1; j <= text2.length(); ++j) {
                temp = f[j];
                if (text1.charAt(i-1) == text2.charAt(j-1)) f[j] = last + 1;
                else f[j] = Math.max(f[j], f[j-1]);
                last = temp;
            }
        }
        return f[text2.length()];
    }
/*    Success:
    Runtime:10 ms, faster than 71.28% of Java online submissions.
    Memory Usage:43.3 MB, less than 55.98% of Java online submissions.*/
/*    Success:
    Runtime:18 ms, faster than 33.71% of Java online submissions.
    Memory Usage:43.7 MB, less than 18.41% of Java online submissions.*/
/*    public int longestCommonSubsequence(String text1, String text2) {
        int[][] f = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i <= text1.length(); ++i) {
            for (int j = 1; j <= text2.length(); ++j) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) f[i][j] = f[i-1][j-1] + 1;
                else f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
            }
        }
        return f[text1.length()][text2.length()];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
