/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null)
            return res;
        Stack<Node> st = new Stack<Node>();
        st.push(root);
        while(!st.empty()) {
            Node cur = st.pop();
            if(cur==null)
                continue;
            res.add(cur.val);
            for(int i=cur.children.size()-1;i>=0;i--) {
                st.push(cur.children.get(i));
            }
        }
        return res;
    }
}
