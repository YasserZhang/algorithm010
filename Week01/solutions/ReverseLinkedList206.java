//Reverse a singly linked list.
//
// Example:
//
//
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
//
//
// Follow up:
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both?
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
    /*    Success:
        Runtime:0 ms, faster than 100.00% of Java online submissions.
        Memory Usage:39.3 MB, less than 60.12% of Java online submissions.*/
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        ListNode prev = null;
        ListNode cur = head;
        while(cur.next != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        cur.next = prev;
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
