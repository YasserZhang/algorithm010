//Given two words word1 and word2, find the minimum number of operations require
//d to convert word1 to word2.
//
// You have the following 3 operations permitted on a word:
//
//
// Insert a character
// Delete a character
// Replace a character
//
//
// Example 1:
//
//
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation:
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
//
//
// Example 2:
//
//
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation:
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
//
// Related Topics String Dynamic Programming
// 👍 4132 👎 57


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*    Success:
        Runtime:4 ms, faster than 95.88% of Java online submissions.
        Memory Usage:39.5 MB, less than 80.16% of Java online submissions.*/
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int n = word1.length();
        int m = word2.length();
        int[][] f = new int[n+1][m+1];
        for (int i = 1; i <=n; ++i) f[i][0] = f[i-1][0] + 1;
        for (int i = 1; i <=m; ++i) f[0][i] = f[0][i-1] + 1;
        for (int i = 1; i <=n; ++i) {
            for (int j = 1; j <=m; ++j) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) f[i][j] = f[i-1][j-1];
                else f[i][j] = Math.min(f[i-1][j-1], Math.min(f[i-1][j],f[i][j-1])) + 1;
            }
        }
        return f[n][m];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
