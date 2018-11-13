class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        int m=matrix.length, n=matrix[0].length, i=0, j=n-1;
        int il = 0, ir = m-1;
        int jl = 0, jr = n-1;
        if(target<matrix[0][0] || target>matrix[m-1][n-1])
            return false;
        while(i<m && j>=0) {
            if(matrix[i][j]>target) {
                j--;
            }else if(matrix[i][j]<target) {
                i++;
            }else {
                return true;
            }
        }
        return false;
    }
}
