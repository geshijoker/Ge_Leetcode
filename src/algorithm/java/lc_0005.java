class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<1) return "";
        String res = "";
        int start = 0, end = 0;
        int n = s.length();
        int len = 0;
        for(int i=0; i<2*n-1; i++) {
            int k = (i-i%2)/2;
            int j = (i+i%2)/2;
            while(k >= 0 && j < n && s.charAt(k) == s.charAt(j)) {
                if(j-k+1>len) {
                    start = k;
                    end = j;
                    len = j-k+1;
                }
                k--;
                j++;
            }
        }
        return s.substring(start, end + 1);
    }
}
