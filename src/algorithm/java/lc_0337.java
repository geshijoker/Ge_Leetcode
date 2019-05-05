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
    public class dpNode {
        int val;
        int leftVal;
        int rightVal;
        dpNode left;
        dpNode right;
        dpNode(int x) { val = x; leftVal = 0; rightVal = 0;}
    }
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        dpNode dpRoot = new dpNode(root.val);
        helper(root, dpRoot);
        return dpRoot.val;
    }
    public void helper(TreeNode root, dpNode dpRoot) {
        dpRoot.val = root.val;
        int leftVal = 0;
        int rightVal = 0;
        if (root.left != null) {
            dpRoot.left = new dpNode(root.left.val);
            helper(root.left, dpRoot.left);
            leftVal = dpRoot.left.val;
        }
        if (root.right != null) {
            dpRoot.right = new dpNode(root.right.val);
            helper(root.right, dpRoot.right);
            rightVal = dpRoot.right.val;
        }
        dpRoot.leftVal = leftVal;
        dpRoot.rightVal = rightVal;
        int valueF = leftVal + rightVal;
        int valueS = dpRoot.val;
        if(dpRoot.left!=null) {
            valueS += (dpRoot.left.leftVal + dpRoot.left.rightVal);
        }
        if(dpRoot.right!=null) {
            valueS += (dpRoot.right.leftVal + dpRoot.right.rightVal);
        }
        dpRoot.val = Math.max(valueF, valueS);
    }
}
