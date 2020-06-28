//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations.
//
// Example:
//
//
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
//
// Related Topics Backtracking


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {



    /*
    Use HashMap to index nums and permutate unique indexes.
       Success:
        Runtime:2 ms, faster than 55.97% of Java online submissions.
        Memory Usage:40.1 MB, less than 59.94% of Java online submissions.*/
/*    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int n : nums) {
            if (dict.containsKey(n)) {
                dict.put(n, dict.get(n)+1);
            } else {
                dict.put(n, 1);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(dict, nums.length, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(Map<Integer, Integer> dict, int length, List<Integer> comb, List<List<Integer>> res) {
        if (length == comb.size()) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        for (Integer num : dict.keySet()) {
            if (dict.get(num) > 0) {
                comb.add(num);
                dict.put(num, dict.get(num)-1);
                dfs(dict, length, comb, res);
                comb.remove(comb.size()-1);
                dict.put(num, dict.get(num) + 1);
            }
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
