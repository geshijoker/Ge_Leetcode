class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0)
            return 0;
        int output = 0;
        int arrayLength = prices.length;
        int pivot = 0;
        int i=1;
        while(i<arrayLength){
            if(prices[i]<prices[i-1]){
                output += prices[i-1]-prices[pivot];
                pivot = i;
            }
            i++;
        }
        output += prices[i-1]-prices[pivot];
        return output;
    }
}
