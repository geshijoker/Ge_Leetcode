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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        long minLeft = Long.MIN_VALUE;
        long maxRight = Long.MAX_VALUE;
        return helper(root, minLeft, maxRight);
    }
    public boolean helper(TreeNode root, long min, long max) {
        if (root==null) return true;
        long rootVal = root.val;
        if (rootVal >= max || rootVal <= min)
            return false;
        return helper(root.left, min, rootVal) && helper(root.right, rootVal, max);
    }
}
