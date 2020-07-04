//Given two words (beginWord and endWord), and a dictionary's word list, find th
//e length of shortest transformation sequence from beginWord to endWord, such tha
//t:
//
//
// Only one letter can be changed at a time.
// Each transformed word must exist in the word list.
//
//
// Note:
//
//
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.
//
//
// Example 1:
//
//
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output: 5
//
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog
//" -> "cog",
//return its length 5.
//
//
// Example 2:
//
//
//Input:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: 0
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
//
//
//
//
// Related Topics Breadth-first Search


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    Success:
    Runtime:108 ms, faster than 40.76% of Java online submissions.
    Memory Usage:63.4 MB, less than 10.97% of Java online submissions.*/

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        Map<String, List<String>> allComboDict = new HashMap<>();
        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                }
        );
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; ++i) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, L);

                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    if (adjacentWord.equals(endWord)) return level + 1;
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }

/*    Compile Error:
    Time Limit Exceeded
    stdout:
            null*/
/*    int min = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        dfs(beginWord, endWord, wordList, visited, 1);
        if (min == Integer.MAX_VALUE) return 0;
        return min;
    }

    private void dfs(String beginWord, String endWord, List<String> wordList, boolean[] visited, int count) {
        if (beginWord.equals(endWord)) {
            this.min = Math.min(count, this.min);
            return;
        }
        for (int i = 0; i < wordList.size(); ++i) {
            if (visited[i] == true) continue;
            if (!oneLetterAway(beginWord, wordList.get(i))) continue;
            visited[i] = true;
            dfs(wordList.get(i), endWord, wordList, visited, count+1);
            visited[i] = false;
        }
    }

    private boolean oneLetterAway(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return count == 1;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
