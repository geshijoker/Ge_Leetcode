class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] diag = new int[2*n-1][2];
        int[] c = new int[n];

        List<char[]> cur = new ArrayList();
        for(int i = 0; i < n; i++) {
            char[] a = new char[n];
            Arrays.fill(a, '.');
            cur.add(a);
        }
        
        List<List<String>> res = new ArrayList<>();
        helper(cur, 0, n, diag, c, res);
        return res;     
    }
    public void helper(List<char[]> cur, int r, int n, int[][] diag, int[] c, List<List<String>> res) {
        if(r == n) {
            List<String> tmp = new ArrayList<>();
            for(char[] a : cur) tmp.add(new String(a));
            res.add(tmp);
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(c[i] == 1 || diag[r + i][0] == 1 || diag[n-1 + r - i][1] == 1) continue;
            c[i] = 1;
            diag[r + i][0] = 1;
            diag[n-1 + r - i][1] = 1;
            
            cur.get(r)[i]= 'Q';
            helper(cur, r + 1, n, diag, c, res);
            cur.get(r)[i]= '.';
            
            c[i] = 0;
            diag[r + i][0] = 0;
            diag[n-1 + r - i][1] = 0;            
        }
    }
}
