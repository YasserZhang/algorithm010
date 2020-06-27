//Invert a binary tree.
//
// Example:
//
// Input:
//
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//
// Output:
//
//
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//
// Trivia:
//This problem was inspired by this original tweet by Max Howell:
//
// Google: 90% of our engineers use the software you wrote (Homebrew), but you c
//an’t invert a binary tree on a whiteboard so f*** off.
// Related Topics Tree


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

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
        Runtime:0 ms, faster than 100.00% of Java online submissions.
        Memory Usage:36.7 MB, less than 77.71% of Java online submissions.*/
    //width first search
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
        return root;
    }

/*    Success:
    Runtime:0 ms, faster than 100.00% of Java online submissions.
    Memory Usage:37.3 MB, less than 12.72% of Java online submissions.*/
/*    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tn = root.left;
        root.left = root.right;
        root.right = tn;
        helper(root.left);
        helper(root.right);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
