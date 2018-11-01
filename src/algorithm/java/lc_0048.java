class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return;
        int n = matrix.length;
        int[] temp = new int[3];
        for(int round=0;round<(int)Math.floor(n/2);round++){
            for(int i=0;i<n-2*round-1;i++){
                temp[0] = matrix[i+round][n-1-round];
                matrix[i+round][n-1-round] = matrix[round][i+round];
                temp[1] = matrix[n-1-round][n-1-(i+round)];
                matrix[n-1-round][n-1-(i+round)] = temp[0];
                temp[2] = matrix[n-1-(i+round)][round];
                matrix[n-1-(i+round)][round] = temp[1];
                matrix[round][i+round] = temp[2];
            }
        }
        return;
    }
}
