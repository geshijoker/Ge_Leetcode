/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        if(root.left!=null){
            root.left.next = root.right;
            connect(root.left);
        }
        if(root.right!=null){
            root.right.next=(root.next!=null)?root.next.left:null;
            connect(root.right);
        }
    }
}
