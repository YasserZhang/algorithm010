//Given a binary tree, return the level order traversal of its nodes' values. (i
//e, from left to right, level by level).
//
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
//
//return its level order traversal as:
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics Tree Breadth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
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
        Runtime:1 ms, faster than 59.38% of Java online submissions.
        Memory Usage:40.6 MB, less than 10.17% of Java online submissions.*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, root, res);
        return res;
    }

    private void dfs(int index, TreeNode node, List<List<Integer>> lists) {
        if (node == null) return;
        if (index == lists.size()) {
            List<Integer> list = new ArrayList<>();
            lists.add(list);
        }
        lists.get(index).add(node.val);
        dfs(index+1, node.left, lists);
        dfs(index+1, node.right, lists);
    }
/*    Success:
    Runtime:3 ms, faster than 6.18% of Java online submissions.
    Memory Usage:40.6 MB, less than 8.80% of Java online submissions.*/
/*    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        System.out.println(queue);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
