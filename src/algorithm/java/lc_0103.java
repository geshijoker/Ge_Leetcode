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
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> lst = new Stack<>();
        lst.push(root);
        boolean reverse = true;
        while(!lst.empty() || !st.empty()) {
            List<Integer> list = new ArrayList<>();
            if(reverse) {
                while(!lst.empty()) {
                    TreeNode levelNode = lst.pop();
                    if(levelNode==null)
                        continue;
                    list.add(levelNode.val);
                    st.push(levelNode.left);
                    st.push(levelNode.right);
                }
                reverse = false;
            }else {
                while(!st.empty()) {
                    TreeNode levelNode = st.pop();
                    if(levelNode==null)
                        continue;
                    list.add(levelNode.val);
                    lst.push(levelNode.right);
                    lst.push(levelNode.left);
                }
                reverse = true;
            }
            if(!list.isEmpty())
                res.add(list);
        }
        return res;
    }
}
