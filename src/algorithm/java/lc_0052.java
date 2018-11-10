class Solution {
    public int totalNQueens(int n) {
        int[] res = new int[1];
        
        List<char[]> cur = new ArrayList<>();
        for(int i=0;i<n;i++) {
            char[] a = new char[n];
            Arrays.fill(a, '.');
            cur.add(a);
        }
        
        int[][] diagv = new int[n*2-1][2];
        int[] colv = new int[n];
        helper(res, n, diagv, colv, cur, 0);
        
        return res[0];
    }
    
    public void helper(int[] res, int n, int[][] diagv, int[] colv, List<char[]> cur, int row) {
        if(row==n) 
            res[0]++;
        for(int i=0;i<n;i++) {
            if(colv[i]==1 || diagv[row+i][0]==1 || diagv[n-1+row-i][1]==1) continue;
            colv[i] = 1;
            diagv[row+i][0] = 1;
            diagv[n-1+row-i][1] = 1;
            
            helper(res, n, diagv, colv, cur, row+1);
            
            colv[i] = 0;
            diagv[row+i][0] = 0;
            diagv[n-1+row-i][1] = 0;
        }
    }
}
