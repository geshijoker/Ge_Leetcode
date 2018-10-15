/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || head==null)
            return head;
        ListNode node = head;
        for(int i=0;i<k;i++, node = node.next) {
            if(node==null)
                return head;
        }
        node = head.next;
        ListNode prev = head;
        for(int i=1;i<k;i++) {
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;                
        }
        head.next = reverseKGroup(node, k);
        return prev;
    }
}
