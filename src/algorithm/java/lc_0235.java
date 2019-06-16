/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        if((root.val-p.val)*(root.val-q.val)>0)
            return (root.val-p.val<0)?lowestCommonAncestor(root.right, p, q):lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
