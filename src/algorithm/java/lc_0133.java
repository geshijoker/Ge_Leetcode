/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        queue.add(node);
        Map<UndirectedGraphNode,UndirectedGraphNode> visited = new HashMap<>();
        visited.put(node,res);
        while(!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            UndirectedGraphNode cloned = visited.get(cur);
            for(UndirectedGraphNode neighbor : cur.neighbors) {
                if(visited.containsKey(neighbor)) {
                    cloned.neighbors.add(visited.get(neighbor));
                }else {
                    queue.offer(neighbor);
                    UndirectedGraphNode copy = new UndirectedGraphNode(neighbor.label);
                    visited.put(neighbor,copy);
                    cloned.neighbors.add(copy);
                }
            }
        }
        return visited.get(node);
    }
}
