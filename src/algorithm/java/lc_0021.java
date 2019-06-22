/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode l3;
        ListNode res;
        if(l1.val<l2.val) {
            l3 = mergeTwoLists(l1.next, l2);
            l1.next = l3;
            res = l1;
        }else {
            l3 = mergeTwoLists(l1, l2.next);
            l2.next = l3;
            res = l2;
        }
       return res;
    }
}
