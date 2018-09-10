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
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                if(cur==null) continue;
                row.add(cur.val);
                for (Node child: cur.children)
                    q.add(child);
            }
            res.add(row);
        }
        return res;
    }
}
