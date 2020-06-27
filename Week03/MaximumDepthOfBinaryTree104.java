//Given a binary tree, find its maximum depth.
//
// The maximum depth is the number of nodes along the longest path from the root
// node down to the farthest leaf node.
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
// return its depth = 3.
// Related Topics Tree Depth-first Search


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
    /*
      when using ArrayDeque
      Success:
        Runtime:2 ms, faster than 13.40% of Java online submissions.
        Memory Usage:40.6 MB, less than 9.40% of Java online submissions.*/
/*
  when using LinkedList
  Success:
    Runtime:1 ms, faster than 13.40% of Java online submissions.
    Memory Usage:39.4 MB, less than 68.58% of Java online submissions.*/
//BFS
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }

/*    Success:
    Runtime:2 ms, faster than 13.40% of Java online submissions.
    Memory Usage:39.3 MB, less than 79.22% of Java online submissions.*/
    //width first search
/*    private class Pair {
        TreeNode node;
        int depth;
        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));
        int max = 0;
        Pair cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.node.left != null) {
                queue.offer(new Pair(cur.node.left, cur.depth+1));
            }
            if (cur.node.right != null) {
                queue.offer(new Pair(cur.node.right, cur.depth+1));
            }
        }
        return Math.max(max,cur.depth);
    }*/

/*    Success:
    Runtime:0 ms, faster than 100.00% of Java online submissions.
    Memory Usage:39.7 MB, less than 36.10% of Java online submissions.*/
/*    public int maxDepth(TreeNode root) {
        return helper(root, 1);
    }
    private int helper(TreeNode node, int level) {
        if (node == null) return level - 1;
        int leftLevel = helper(node.left, level + 1);
        int rightLevel = helper(node.right, level + 1);
        return Math.max(leftLevel, rightLevel);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
