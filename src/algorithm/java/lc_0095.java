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
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<TreeNode>();
        List<TreeNode> res = allTrees(1,n);
        return res;
    }
    public List<TreeNode> allTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start>end) {
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++) {
            List<TreeNode> leftList = allTrees(start, i-1);
            List<TreeNode> rightList = allTrees(i+1, end);
            for(TreeNode leftNode : leftList) {
                for(TreeNode rightNode : rightList) {
                    TreeNode rootNode = new TreeNode(i);
                    rootNode.left = leftNode;
                    rootNode.right = rightNode;
                    list.add(rootNode);
                }
            }
        }
        return list;
    }
}
