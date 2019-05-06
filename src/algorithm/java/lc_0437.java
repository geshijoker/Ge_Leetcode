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
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        helper(root, sum, new ArrayList<>());
        return count;
    }
    public void helper(TreeNode root, int sum, List<Integer> memo) {
        if(root==null)
            return;
        List<Integer> temp_memo = new ArrayList<>();
        temp_memo.add(root.val);
        for(Integer m : memo) {
            temp_memo.add(root.val + m);
        }
        for(Integer m : temp_memo) {
            if(m == sum)
                count++;
        }
        helper(root.left, sum, temp_memo);
        helper(root.right, sum, temp_memo);
        return;
    }
}
