/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        int level = 0;
        Map<Integer, Node> map = new HashMap<>();
        helper(root, map, level);
        return root;
    }
    public void helper(Node root, Map<Integer, Node> map, int level) {
        if(root!=null) {
            if(level<map.size()) {
                Node cur = map.get(level);
                cur.next = root;
            }
            map.put(level, root);
            helper(root.left, map, level+1);
            helper(root.right, map, level+1);
        }
    }
}
