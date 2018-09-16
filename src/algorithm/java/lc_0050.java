class Solution {
    public double myPow(double x, int n) {
        double r = 1;
        if (n == Integer.MIN_VALUE) {
            r = 1 / x;
            n = n + 1;
        }
        
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        
        while (n > 0) {
            if ((n & 1) == 1) {
                r = r * x;
            }
            x = x * x;
            n = n >> 1;
        }
        
        return r;
    }
}
