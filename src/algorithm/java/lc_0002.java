/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode output = new ListNode((l1.val + l2.val)%10);
        int upper=(int) (l1.val + l2.val)/10;    
        ListNode node = output;
        while (temp1.next!=null && temp2.next!=null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            node.next = new ListNode((int) (temp1.val + temp2.val + upper)%10);
            upper = (int) (temp1.val + temp2.val + upper)/10;
            node = node.next;
        }
        while (temp1.next!=null) {
            temp1 = temp1.next;
            node.next = new ListNode((int) (temp1.val + upper)%10);
            upper = (int) (temp1.val + upper)/10;
            node = node.next;
        }
        while (temp2.next!=null) {
            temp2 = temp2.next;
            node.next = new ListNode((int) (temp2.val + upper)%10);
            upper = (int) (temp2.val + upper)/10;
            node = node.next;
        }
        if (upper!=0) {
            node.next = new ListNode(1);
        }
        return output;
    }
}
