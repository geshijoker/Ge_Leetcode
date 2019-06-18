class Solution {
    public int numSquares(int n) {
        if(n<=0)
            return -1;
        int[] resTemp = new int[n+1];
        Arrays.fill(resTemp, n);
        int temp = (int)(Math.sqrt(n));
        resTemp[0] = 0;
        resTemp[1] = 1;
        
        for(int i=2;i<=n;i++) {
            for(int j=1;j<=temp;j++) {
                if(i-j*j>=0) {
                    resTemp[i] = Math.min(resTemp[i],resTemp[i-j*j]+1);
                }else
                    break;
            }
        }
        return resTemp[n];
    }
}
