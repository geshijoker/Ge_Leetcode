class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length<1 || matrix[0]==null || matrix[0].length<1)
            return null;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] res = new int[rows][cols];
        Queue<List<Integer>> q = new LinkedList<>();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(matrix[i][j]==0) {
                    res[i][j] = 0;
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    q.add(tmp);
                }else
                    res[i][j] = 100;
            }
        }
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while(!q.isEmpty()) {
            List<Integer> cur = q.poll();
            int cur_r = cur.get(0), cur_c = cur.get(1);
            for(int i=0;i<4;i++) {
                int new_r = cur_r + dir[i][0], new_c = cur_c + dir[i][1];
                if(new_r >= 0 && new_r < rows && new_c >=0 && new_c < cols) {
                    if(res[new_r][new_c] > res[cur_r][cur_c]+1) {
                        res[new_r][new_c] = res[cur_r][cur_c]+1;
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(new_r);
                        tmp.add(new_c);
                        q.add(tmp);
                    }
                }
            }
        }
        return res;
    }
}
