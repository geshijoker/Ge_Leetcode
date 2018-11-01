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
        boolean flag = false;
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> lst = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        TreeNode cur = root;
        int level = 0;
        while(cur!=null || !st.empty()) {
            while(cur!=null) {
                if(level>=res.size())
                    res.add(new ArrayList<Integer>());
                st.push(cur);
                lst.push(level);
                cur = cur.left;
                level = level+1;
            }
            cur = st.pop();
            level = lst.pop();
            List<Integer> llist = res.get(level);
            if(level%2==0)
                llist.add(cur.val);
            else
                llist.add(0, cur.val);
            cur = cur.right;
            level = level+1;
        }
        return res;
    }
}
