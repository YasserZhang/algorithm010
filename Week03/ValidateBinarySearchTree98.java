//Given a binary tree, determine if it is a valid binary search tree (BST).
//
// Assume a BST is defined as follows:
//
//
// The left subtree of a node contains only nodes with keys less than the node's
// key.
// The right subtree of a node contains only nodes with keys greater than the no
//de's key.
// Both the left and right subtrees must also be binary search trees.
//
//
//
//
// Example 1:
//
//
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
//
//
// Example 2:
//
//
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
//
// Related Topics Tree Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

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
        Memory Usage:39.7 MB, less than 21.58% of Java online submissions.*/
    public boolean isValidBST(TreeNode root) {
        Stack<Integer> list = new Stack<>();
        return inorder(root, list);
    }

    private boolean inorder(TreeNode node, Stack<Integer> stack) {
        if (node == null) return true;
        if (!inorder(node.left, stack)) return false;
        if (!stack.isEmpty() && stack.peek() >= node.val) return false;
        stack.push(node.val);
        if (!inorder(node.right, stack)) return false;
        return true;

    }

/*    Success:
    Runtime:0 ms, faster than 100.00% of Java online submissions.
    Memory Usage:39.4 MB, less than 32.26% of Java online submissions.*/
/*    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;
        if (lower != null && node.val <= lower) return false;
        if (upper != null && node.val >= upper) return false;

        if (!helper(node.left, lower, node.val)) return false;
        if (!helper(node.right, node.val, upper)) return false;
        return true;
    }*/

/*    Success:
    Runtime:1 ms, faster than 36.53% of Java online submissions.
    Memory Usage:39.2 MB, less than 52.67% of Java online submissions.*/
/*    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i-1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
