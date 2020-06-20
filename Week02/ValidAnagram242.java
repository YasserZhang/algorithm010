//Given two strings s and t , write a function to determine if t is an anagram o
//f s.
//
// Example 1:
//
//
//Input: s = "anagram", t = "nagaram"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "rat", t = "car"
//Output: false
//
//
// Note:
//You may assume the string contains only lowercase alphabets.
//
// Follow up:
//What if the inputs contain unicode characters? How would you adapt your soluti
//on to such case?
// Related Topics Hash Table Sort


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            counter[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); ++i) {
            if (--counter[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

/*    Success:
    Runtime:3 ms, faster than 73.66% of Java online submissions.
    Memory Usage:39.1 MB, less than 97.32% of Java online submissions.*/
/*    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < counter.length; ++i) {
            if (counter[i] != 0) {
                return false;
            }
        }
        return true;
    }*/


/*    Success:
    Runtime:16 ms, faster than 12.16% of Java online submissions.
    Memory Usage:40.2 MB, less than 31.37% of Java online submissions.*/
/*    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> dict = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            if (dict.containsKey(s.charAt(i))) {
                dict.put(s.charAt(i), dict.get(s.charAt(i)) + 1);
            }
            else {
                dict.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); ++i) {
            if (dict.containsKey(t.charAt(i))) {
                dict.put(t.charAt(i), dict.get(t.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        for (Integer i : dict.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
