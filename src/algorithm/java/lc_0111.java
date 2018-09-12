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
    public int minDepth(TreeNode root) {
        int res=0;
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)
            return res;
        q.offer(root);
        res++;
        while(!q.isEmpty()) {
            int num = q.size();
            for(int i=0;i<num;i++) {
                TreeNode cur = q.poll();
                if(cur.left==null && cur.right==null) 
                    return res;
                if(cur.left!=null)
                    q.offer(cur.left);
                if(cur.right!=null)
                    q.offer(cur.right);
            }
            res++;
        }
        return res;
    }
}
