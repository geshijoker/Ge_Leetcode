class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int res = 0;
        if(grid.size()==0 || grid[0].size()==0)
            return res;
        int m = grid.size();
        int n = grid[0].size();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]=='1') {
                    DFS(grid, i, j, m, n);
                    res++;
                }
            }
        }
        return res;
    }
    void DFS(vector<vector<char>>& grid, int i, int j, int row, int col) {
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j]!='1')
            return;
        grid[i][j]='0';
        DFS(grid, i+1, j, row, col);
        DFS(grid, i, j+1, row, col);
        DFS(grid, i-1, j, row, col);
        DFS(grid, i, j-1, row, col);
    }
};