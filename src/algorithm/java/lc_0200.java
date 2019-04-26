class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || (grid[0]).length==0)
            return 0;
        int row = grid.length;
        int col = (grid[0]).length;
        int output = 0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    DFS(grid, i, j, row, col);
                    output++;
                }
            }
        }
        return output;
    }
    public void DFS(char[][] grid, int i, int j, int row, int col){
        if(i<0 || j<0 || i>=row || j>=col || grid[i][j]!='1') return;
        grid[i][j]='0';
        DFS(grid, i+1, j, row, col);
        DFS(grid, i-1, j, row, col);
        DFS(grid, i, j+1, row, col);
        DFS(grid, i, j-1, row, col);
    }
}
