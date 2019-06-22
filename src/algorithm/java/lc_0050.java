class Solution {
    public double myPow(double x, int n) {
        if (x == 1 || n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) {
            return 1 / (x*myPow(x, -1*(n+1)));
        }
        double res = 1;
        while (n > 1) {
            if (n % 2 == 1) {
                res *= x;
                n -= 1;
            }
            n = n/2;
            x = x*x;
        }

        return res*x;
    }
}
