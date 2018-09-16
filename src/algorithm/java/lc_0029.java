class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        int flag=1;
        if(dividend<0 && divisor>0 || dividend>0 && divisor<0)
            flag = -1;
        if(dividend>0)
            dividend = -dividend;
        if(divisor>0)
            divisor = -divisor;
        if(dividend>divisor)
            return 0;
        int res = 0;
        while(dividend<=divisor) {
            int tempDivisor = divisor;
            int count = 1;
            while(dividend - tempDivisor < tempDivisor) {
                tempDivisor *= 2;
                count *=2;
            }
            res+=count;
            dividend-=tempDivisor;
        }
        return res * flag;
    }
}
