//You need to find the largest value in each row of a binary tree.
//
// Example:
//
//Input:
//
//          1
//         / \
//        3   2
//       / \   \
//      5   3   9
//
//Output: [1, 3, 9]
//
//
// Related Topics Tree Depth-first Search Breadth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /*    Success:
        Runtime:3 ms, faster than 23.30% of Java online submissions.
        Memory Usage:42.2 MB, less than 10.36% of Java online submissions.*/
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.add(max);
        }
        return list;
    }


/*    Success:
    Runtime:1 ms, faster than 90.26% of Java online submissions.
    Memory Usage:39.6 MB, less than 74.80% of Java online submissions.*/
/*    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(0, root, list);
        return list;
    }

    private void dfs(int index, TreeNode node, List<Integer> list) {
        if (node == null) return;
        if (index == list.size()) {
            list.add(Integer.MIN_VALUE);
        }
        list.set(index, Math.max(list.get(index), node.val));
        dfs(index+1, node.left, list);
        dfs(index+1, node.right, list);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
