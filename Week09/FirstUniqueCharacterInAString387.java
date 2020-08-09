//Given a string, find the first non-repeating character in it and return its in
//dex. If it doesn't exist, return -1.
//
// Examples:
//
//
//s = "leetcode"
//return 0.
//
//s = "loveleetcode"
//return 2.
//
//
//
//
// Note: You may assume the string contains only lowercase English letters.
// Related Topics Hash Table String
// 👍 2021 👎 117


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*    Success:
        Runtime:8 ms, faster than 84.16% of Java online submissions.
        Memory Usage:39.8 MB, less than 89.16% of Java online submissions.*/
    public int firstUniqChar(String s) {
        int[] counter = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            int idx = s.charAt(i) - 'a';
            counter[idx]++;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (counter[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;

    }

/*    Success:
    Runtime:38 ms, faster than 28.79% of Java online submissions.
    Memory Usage:40 MB, less than 76.37% of Java online submissions.*/
/*    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        new
        for (int i=0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i=0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
