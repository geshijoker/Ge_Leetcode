class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<Integer>(n);
        if(n==0) return leaves;
        if(edges==null || edges.length==0) {
            for(int i=0;i<n;i++)
                leaves.add(i);
            return leaves;
        }
        
        List<HashSet<Integer>> graph = new ArrayList<>(n);
        for(int i=0;i<n;i++) graph.add(new HashSet<Integer>());
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        for(int i=0;i<n;i++) {
            //System.out.println(graph.get(i).size());
            if(graph.get(i).size()==1)
                leaves.add(i);
        }
        
        while(n>2) {
            n-=leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for(int leave : leaves) {
                int newLeave = graph.get(leave).iterator().next();
                graph.get(newLeave).remove(leave);
                if(graph.get(newLeave).size()==1) newLeaves.add(newLeave);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
