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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre==null || pre.length<1 || post==null || post.length<1)
            return null;
        return helper(pre, post, 0, 0, pre.length);
    }
    public TreeNode helper(int[] pre, int[] post, int i0, int i1, int N) {
        if (N==0) return null;
        TreeNode root = new TreeNode(pre[i0]);
        if (N==1) return root;
        
        int L = 1;
        for(; L<N; L++) {
            if (post[i1+L-1]==pre[i0+1])
                break;
        }
        System.out.println(L);
        root.left = helper(pre, post, i0+1, i1, L);
        root.right = helper(pre, post, i0+L+1, i1+L, N-1-L);
        return root;
    }
}
