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
        Set<Node> explored = new HashSet<>();
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node curr = s.pop();
            if (explored.contains(curr)) {
                res.add(curr.val);
                continue;
            }
            
            s.push(curr);
            for (int i = curr.children.size() - 1; i >= 0; i--) {
                s.push(curr.children.get(i));   
            }            
            explored.add(curr);
        }        
        return res; 
    }
}
