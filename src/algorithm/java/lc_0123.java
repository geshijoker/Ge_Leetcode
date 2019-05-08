class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2)
            return 0;
        int n = prices.length;
        int s0 = 0;
        int s1 = Integer.MIN_VALUE;
        int s2 = Integer.MIN_VALUE;
        int s3 = Integer.MIN_VALUE;
        int s4 = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            s1 = Math.max(s1, s0-prices[i]);
            s2 = Math.max(s2, s1+prices[i]);
            s3 = Math.max(s3, s2-prices[i]);
            s4 = Math.max(s4, s3+prices[i]);
        }
        return s4;
    }
}
