//A gene string can be represented by an 8-character long string, with choices f
//rom "A", "C", "G", "T".
//
// Suppose we need to investigate about a mutation (mutation from "start" to "en
//d"), where ONE mutation is defined as ONE single character changed in the gene s
//tring.
//
// For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
//
// Also, there is a given gene "bank", which records all the valid gene mutation
//s. A gene must be in the bank to make it a valid gene string.
//
// Now, given 3 things - start, end, bank, your task is to determine what is the
// minimum number of mutations needed to mutate from "start" to "end". If there is
// no such a mutation, return -1.
//
// Note:
//
//
// Starting point is assumed to be valid, so it might not be included in the ban
//k.
// If multiple mutations are needed, all mutations during in the sequence must b
//e valid.
// You may assume start and end string is not the same.
//
//
//
//
// Example 1:
//
//
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//return: 1
//
//
//
//
// Example 2:
//
//
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//return: 2
//
//
//
//
// Example 3:
//
//
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//return: 3
//
//
//
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


/*    Success:
    Runtime:0 ms, faster than 100.00% of Java online submissions.
    Memory Usage:37.2 MB, less than 66.57% of Java online submissions.*/

    private int min = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        //first find genes in the bank that has only one diff with the start
        //they are the candidate for change
        //iterate through the process until match the end
        boolean[] visited = new boolean[bank.length];
        dfs(start, end, 0, bank, visited);
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    private void dfs(String start, String end, int count, String[] bank, boolean[] visited) {
        if (match(start, end)) {
            this.min = Math.min(count, this.min);
        }
        for (int i = 0; i < bank.length; ++i) {
            if (visited[i] == true) continue;
            if (isOneCharAway(start, bank[i])) {
                visited[i] = true;
                dfs(bank[i], end, count+1, bank, visited);
                visited[i] = false;
            }
        }
    }

    private boolean isOneCharAway(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return count == 1;
    }

    private boolean match(String a, String b) {
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
