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
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int res = helper(root, 0, 0);
        return res;
    }
    public int helper(TreeNode root, int depth, int res) {
        if(root==null)
            return Math.max(res, depth);
        res = Math.max(res, depth+1);
        res = helper(root.left, depth+1, res);
        res = helper(root.right, depth+1, res);
        return res;
    }
}
