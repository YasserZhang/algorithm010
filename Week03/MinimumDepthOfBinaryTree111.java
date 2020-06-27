//Given a binary tree, find its minimum depth.
//
// The minimum depth is the number of nodes along the shortest path from the roo
//t node down to the nearest leaf node.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given binary tree [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// return its minimum depth = 2.
// Related Topics Tree Depth-first Search Breadth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

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
        Runtime:1 ms, faster than 12.58% of Java online submissions.
        Memory Usage:39.4 MB, less than 73.19% of Java online submissions.*/
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (isLeafNode(node)) {
                    return depth;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        //should never come here.
        return -1;
    }

    private boolean isLeafNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }




/*    Success:
    Runtime:0 ms, faster than 100.00% of Java online submissions.
    Memory Usage:41.4 MB, less than 5.89% of Java online submissions.*/
/*    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 1);
    }

    private int helper(TreeNode node, int depth) {
        if (node == null) return Integer.MAX_VALUE;
        if (isLeafNode(node)) return depth;
        int leftDepth = helper(node.left, depth+1);
        int rightDepth = helper(node.right, depth+1);
        return Math.min(leftDepth,rightDepth);
    }

    private boolean isLeafNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }*/


}
//leetcode submit region end(Prohibit modification and deletion)
