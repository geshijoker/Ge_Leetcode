class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<numCourses;i++) map.put(i,new LinkedList<>());
        for(int[] prerequisite : prerequisites) map.get(prerequisite[0]).add(prerequisite[1]);
        
        boolean[] visited = new boolean[numCourses];
        boolean[] stacked = new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++)
            if(isCyclic(i,visited,stacked,map))
                return false;
        return true;
    }
    public boolean isCyclic(int i, boolean[] visited, boolean[] stacked, Map<Integer,List<Integer>> map) {
        if(visited[i])
            return false;
        if(stacked[i])
            return true;
        stacked[i] = true;
        for(int child : map.get(i)) {
            if(isCyclic(child,visited,stacked,map))
                return true;
        }
        stacked[i] = false;
        visited[i] = true;
        
        return false;
    }
}
