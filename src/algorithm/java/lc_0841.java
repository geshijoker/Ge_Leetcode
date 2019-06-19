class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms==null || rooms.size()<1)
            return true;
        int n_rooms = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(0);
        visited.add(0);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                List<Integer> cur = rooms.get(q.poll());
                for(int key : cur) {
                    if(!visited.contains(key)) {
                        q.add(key);
                        visited.add(key);
                    }
                }
            }
        }
        return visited.size()==n_rooms;
    }
}
