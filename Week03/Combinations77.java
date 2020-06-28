//Given two integers n and k, return all possible combinations of k numbers out
//of 1 ... n.
//
// Example:
//
//
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
// Related Topics Backtracking


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*    Success:
        Runtime:34 ms, faster than 23.04% of Java online submissions.
        Memory Usage:52.2 MB, less than 16.80% of Java online submissions.*/
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, 1, n, k, new ArrayList<Integer>());
        return ans;

    }
    private void dfs(List<List<Integer>> ans, int index,int n, int k, List<Integer> comb) {
        if (k == comb.size()) {
            ans.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = index; i <= n; ++i) {
            comb.add(i);
            dfs(ans,i+1, n, k, comb);
            comb.remove(comb.size() - 1);
        }
    }


/*    Success:
    Runtime:30 ms, faster than 25.05% of Java online submissions.
    Memory Usage:53.4 MB, less than 5.02% of Java online submissions.*/
/*    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, 1, n, k, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int i, int n, int k, List<Integer> comb) {
        if (k == comb.size()) {
            ans.add(new ArrayList<Integer>(comb));
            return;
        }
        if (i > n) return;
        if (i < n) {
            dfs(ans, i+1, n, k, comb);
        }
        comb.add(i);
        dfs(ans,i+1,n,k,comb);
        comb.remove(comb.size()-1);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
