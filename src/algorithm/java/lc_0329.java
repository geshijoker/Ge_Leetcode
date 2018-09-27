class Solution {
    public static final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) 
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int res = 1;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int path = dfs(matrix, m, n, i, j, cache);
                res = Math.max(res,path);
            }
        }
        return res;
    }
    public int dfs(int[][] matrix, int m, int n, int i, int j, int[][] cache) {
        if(cache[i][j]!=0)
            return cache[i][j];
        int max = 1;
        for(int[] direction : directions) {
            int x = i+direction[0];
            int y = j+direction[1];
            if(x<0 || x>=m || y<0 || y>=n || matrix[x][y]<=matrix[i][j])
                continue;
            int cur = dfs(matrix, m, n, x, y, cache)+1;
            max = Math.max(max,cur);
        }
        cache[i][j] = max;
        return max;
    }
}
