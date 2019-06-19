/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> cloneMap = new HashMap<Node, Node>();
        return helper(node, cloneMap);
    }
    public Node helper(Node node, HashMap<Node, Node> map) {
        if (node == null)
            return null;
        if (map.containsKey(node)) {
            return map.get(node);
        }
        List<Node> neighbors = new ArrayList<Node>();
        Node clone = new Node(node.val, neighbors);
        map.put(node, clone);
        for (Node neighbor: node.neighbors) {
            clone.neighbors.add(helper(neighbor, map));
        }
        return clone;
    }
}
