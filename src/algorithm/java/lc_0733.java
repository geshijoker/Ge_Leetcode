class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length<1 || image[0].length<1) return null;
        int rows = image.length;
        int cols = image[0].length;
        if(sr<0 || sr>=rows || sc<0 || sc>=cols) return image;
        int[][] dir = {{0,-1}, {0,1}, {-1,0}, {1,0}};
        Queue<List<Integer>> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        List<Integer> first = new ArrayList<>();
        first.add(sr);
        first.add(sc);
        q.add(first);
        visited[sr][sc] = true;
        int curColor = image[sr][sc];
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                List<Integer> cur = q.poll();
                int cur_r = cur.get(0), cur_c = cur.get(1);
                image[cur_r][cur_c] = newColor;
                for(int j=0;j<4;j++) {
                    int new_r = cur_r + dir[j][0], new_c = cur_c + dir[j][1];
                    if(new_r<0 || new_r>=rows || new_c<0 || new_c>=cols || visited[new_r][new_c]) continue;
                    visited[new_r][new_c] = true;
                    if(image[new_r][new_c] == curColor) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(new_r);
                        tmp.add(new_c);
                        q.add(tmp);
                    }
                }
            }
        }
        return image;
    }
}
