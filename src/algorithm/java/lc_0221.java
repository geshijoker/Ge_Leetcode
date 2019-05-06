class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        int res = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                int num = matrix[i][j];
                if(num=='1') {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1],dp[i][j]), dp[i+1][j])+1;
                    res = Math.max(res, dp[i+1][j+1]);
                }
            }
        }
        return res*res;
    }
}
