/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode nhead = head.next;
        ListNode tmp = nhead.next;
        head.next = tmp;
        nhead.next = head;
        head.next = swapPairs(tmp);
        return nhead;
    }
}
