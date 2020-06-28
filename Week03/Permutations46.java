//Given a collection of distinct integers, return all possible permutations.
//
// Example:
//
//
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
//
// Related Topics Backtracking


import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*    Success:
        Runtime:1 ms, faster than 91.86% of Java online submissions.
        Memory Usage:39.7 MB, less than 62.26% of Java online submissions.*/
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> output = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int n : nums) {
            output.add(n);
        }
        backtrack(nums.length, output, res, 0);
        return res;
    }

    private void backtrack(int n,
                           List<Integer> output,
                           List<List<Integer>> res,
                           int first) {
        if (first == n) res.add(new ArrayList<Integer>(output));
        for (int i = first; i < n; ++i) {
            Collections.swap(output, first, i);
            backtrack(n, output, res, first+1);
            Collections.swap(output, first, i);
        }
    }

/*
  维护一个标记数组
  Success:
    Runtime:1 ms, faster than 91.86% of Java online submissions.
    Memory Usage:39.9 MB, less than 35.63% of Java online submissions.*/
/*    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(ans, nums, visited, new Stack<Integer>());
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, boolean[] visited, Stack<Integer> comb) {
        if (nums.length == comb.size()) {
            ans.add(new ArrayList<Integer>(comb));
            return;
        }

        for(int i = 0; i < nums.length; ++i) {
            if (visited[i] == true) continue;
            comb.push(nums[i]);
            visited[i] = true;
            dfs(ans, nums, visited, comb);
            comb.pop();
            visited[i] = false;
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
