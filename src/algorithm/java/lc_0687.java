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
    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        int temp = inorderTraverse(root, res);
        return res[0];
    }
    
    public int inorderTraverse(TreeNode root, int[] res) {
        if(root==null)
            return 0;
        int left = inorderTraverse(root.left, res);
        int right = inorderTraverse(root.right, res);
        left = (root.left!=null && root.left.val==root.val)? left+1: 0;
        right = (root.right!=null && root.right.val==root.val)? right+1: 0;
        res[0] = Math.max((left+right),res[0]);
        return Math.max(left,right);
    }
}
