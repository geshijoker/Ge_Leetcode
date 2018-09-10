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
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        helper(root, res, 0);
        return res;
    }
    public void helper(Node root,  List<List<Integer>> res, int level) {
        if(root==null) return;
        List<Integer> row;
        if(level>=res.size()) {
            row = new ArrayList<>();
            row.add(root.val);
            res.add(row);
        }
        else {
            row = res.get(level);
            row.add(root.val);
        }
        for (Node child : root.children) {
            helper(child,  res, level+1);
        }
    }
}
