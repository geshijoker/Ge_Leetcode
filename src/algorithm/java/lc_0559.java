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
    public int maxDepth(Node root) {
        int res=0;
        res=helper(root, res);
        return res;
    }
    public int helper(Node root, int res) {
        if(root==null)
            return res;
        res++;
        int temp=res;
        for(Node child : root.children) {
            res=Math.max(res,helper(child, temp));
        }
        return res;
    }
}
