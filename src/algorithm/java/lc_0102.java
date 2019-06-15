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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        helper(root, arr, 0);
        return arr;
    }
    public void helper(TreeNode root, List<List<Integer>> arr, int level) {
        if(root!=null) {
            List<Integer> res;
            if(level>=arr.size()) {
                res = new ArrayList<>();
                res.add(root.val);
                arr.add(res);
            }else {
                res = arr.get(level);
                res.add(root.val);
            }
            helper(root.left, arr, level+1);
            helper(root.right, arr, level+1);
        }
    }
}
