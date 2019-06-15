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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        helper(root, arr);
        return arr;
    }
    public void helper(TreeNode root, List<Integer> arr) {
        if(root!=null) {
            helper(root.left, arr);
            arr.add(root.val);
            helper(root.right, arr);
        }
    }
}
