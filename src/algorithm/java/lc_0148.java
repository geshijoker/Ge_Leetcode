/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode fast = head.next;
        ListNode slow = head;
        int i= 0;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nhead = slow.next;
        slow.next = null;
        head = sortList(head);
        nhead = sortList(nhead);
        ListNode res = merge(head, nhead);
        return res;
    }
    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val <= head2.val) {
            head1.next = this.merge(head1.next, head2);
            return head1;
        } else {
            head2.next = this.merge(head1, head2.next);
            return head2;
        }
    }
}
