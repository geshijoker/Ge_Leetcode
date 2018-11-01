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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList();
        helper(root,list,0);
        return list;
    }
    public void helper(TreeNode root, List<List<Integer>> list, int level){
        if(root==null) return;
        if(level>=list.size()){
            list.add(new ArrayList());
        }
        if(level%2==0){
            list.get(level).add(root.val);
        }else{
            list.get(level).add(0,root.val);
        }
        helper(root.left,list,level+1);
        helper(root.right,list,level+1);
    }
}
