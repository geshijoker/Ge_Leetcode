class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<numCourses;i++) map.put(i,new LinkedList<>());
        for(int[] prerequisite : prerequisites) map.get(prerequisite[0]).add(prerequisite[1]);
        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[numCourses];
        
        boolean[] visited = new boolean[numCourses];
        boolean[] traveled = new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++)
            if(isCyclic(i,visited,traveled,map,q))
                return new int[0];
        int k = 0; 
        
        while(!q.isEmpty()) {
            res[k++] = q.poll();
        }
        return res;
    }
    public boolean isCyclic(int i, boolean[] visited, boolean[] traveled, Map<Integer,List<Integer>> map,Queue<Integer> q) {
        if(visited[i])
            return false;
        if(traveled[i])
            return true;
        traveled[i] = true;
        for(int child : map.get(i)) {
            if(isCyclic(child,visited,traveled,map,q))
                return true;
        }
        traveled[i] = false;
        visited[i] = true;
        q.offer(i);
        return false;
    }
}
