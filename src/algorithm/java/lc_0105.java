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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int indexPre = 0;
        int indexIn = 0;
        
        if( preorder  == null || preorder.length<1 || inorder == null || inorder.length<1 ) {
            return null;
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for( int i=0;i<inorder.length;i++ ){
            map.put(inorder[i],i);
        }
        
        return helper( 0,preorder, inorder,0,inorder.length-1,map );
    }
    
    public TreeNode helper(int rootIndex,int[] preorder, int[] inorder, int startin, int endin ,Map<Integer,Integer> map){
        
        if( startin > endin || rootIndex<0 || rootIndex>=preorder.length ){
            return null;
        }
        
        TreeNode rootNode = new TreeNode(preorder[rootIndex]);
        Integer rootLocationInOrder = map.get(rootNode.val);
        
        rootNode.left = helper(rootIndex+1,preorder, inorder,startin, rootLocationInOrder-1,map );
        int left = rootLocationInOrder - startin;
        rootNode.right = helper(rootIndex+left+1,preorder, inorder,rootLocationInOrder+1,  endin ,map);
        
        return rootNode;
        
    }
}
