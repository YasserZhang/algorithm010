//Merge two sorted linked lists and return it as a new sorted list. The new list
// should be made by splicing together the nodes of the first two lists.
//
// Example:
//
//
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
//
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //basically this is the algorithm for the merge in mergesort algorithm.
    //brute force
/*    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode prev = l3;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = (l1 != null) ? l1 : l2;
        return l3.next;
    }*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
