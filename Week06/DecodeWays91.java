//A message containing letters from A-Z is being encoded to numbers using the fo
//llowing mapping:
//
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// Given a non-empty string containing only digits, determine the total number o
//f ways to decode it.
//
// Example 1:
//
//
//Input: "12"
//Output: 2
//Explanation: It could be decoded as "AB" (1 2) or "L" (12).
//
//
// Example 2:
//
//
//Input: "226"
//Output: 3
//Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)
//.
// Related Topics String Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*    Success:
        Runtime:2 ms, faster than 72.23% of Java online submissions.
        Memory Usage:39.5 MB, less than 27.22% of Java online submissions.*/
    public int numDecodings(String s) {
        int[] f = new int[s.length() + 1];
        f[0] = 1;
        f[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int twoDigit = Integer.valueOf(s.substring(i-2, i));
            int oneDigit = Integer.valueOf(s.substring(i-1, i));
            if (oneDigit >= 1 && oneDigit <= 9) f[i] += f[i-1];
            if (twoDigit >= 10 && twoDigit <= 26) f[i] += f[i-2];
        }
        return f[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
