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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        helper(root, arr);
        return arr;
    }
    public void helper(TreeNode root, List<Integer> arr) {
        if(root!=null) {
            arr.add(root.val);
            helper(root.left, arr);
            helper(root.right, arr);
        }
    }
}
