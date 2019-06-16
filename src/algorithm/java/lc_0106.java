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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if( inorder  == null || inorder.length<1 || postorder == null || postorder.length<1 ) {
            return null;
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for( int i=0;i<inorder.length;i++ ){
            map.put(inorder[i],i);
        }
        
        return helper(postorder.length-1, postorder, inorder, 0, inorder.length-1, map);
    }
    public TreeNode helper(int rootIndex, int[] postorder, int[] inorder, int startin, int endin ,Map<Integer,Integer> map){
        if( startin > endin || rootIndex<0 || rootIndex>=postorder.length){
            return null;
        }
        TreeNode rootNode = new TreeNode(postorder[rootIndex]);
        Integer rootLocationInOrder = map.get(rootNode.val);
        
        int right = endin - rootLocationInOrder;
        rootNode.left = helper(rootIndex-right-1, postorder, inorder, startin, rootLocationInOrder-1, map);
        rootNode.right = helper(rootIndex-1, postorder, inorder, rootLocationInOrder+1, endin, map);
        
        return rootNode;
    }
}
