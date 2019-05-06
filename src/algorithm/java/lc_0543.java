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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int res1 = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        int res2 = helper(root.left) + helper(root.right);
        return Math.max(res1, res2);
    }
    public int helper(TreeNode root) {
        if(root==null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        return Math.max(left,right)+1;
    }
}
