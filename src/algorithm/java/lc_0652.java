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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> count = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        helper(root, count, res);
        return res;
    }
    public String helper(TreeNode root, Map<String, Integer> count, List<TreeNode> res) {
        if(root == null) return "#";
        String code = root.val + "," + helper(root.left, count, res) + "," + helper(root.right, count, res);
        count.put(code, count.getOrDefault(code, 0)+1);
        if(count.get(code)==2)
            res.add(root);
        return code;
    }
