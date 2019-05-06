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
    public TreeNode convertBST(TreeNode root) {
        if(root==null)
            return root;
        List<Integer> memo = new ArrayList<>();
        helper(root, memo);
        return root;
    }
    public void helper(TreeNode root, List<Integer> memo) {
        if(root==null)
            return;
        helper(root.right, memo);
        memo.add((memo.size()==0)? root.val : root.val + memo.get(memo.size()-1));
        root.val = memo.get(memo.size()-1);
        helper(root.left, memo);
    }
}
