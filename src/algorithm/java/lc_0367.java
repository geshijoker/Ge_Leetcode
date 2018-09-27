class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==0)
            return true;
        int left = 1;
        int right = num;
        int factor = (left+right)/2;
        while(left<right) {
            if(factor>num/factor) {
                right = factor-1;
                left = num/factor+1;
            }
            else if(factor<num/factor) {
                left = factor+1;
                right = num/factor-1;
            }
            else
                break;
            factor = (left+right)/2;
        }
        factor = (left+right)/2;
        if(num/factor==factor && num%factor==0)
            return true;
        else
            return false;
    }
}
