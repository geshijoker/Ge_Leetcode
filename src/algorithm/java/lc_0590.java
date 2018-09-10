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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        helper(root, res);       
        return res; 
    }
    public void helper(Node root, List<Integer> res) {
        if(root==null)
            return;
        for(Node child : root.children) {
            helper(child, res);
        }
        res.add(root.val);
    }
}
