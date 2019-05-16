class Solution {
    public int countSubstrings(String S) {
        if(S==null || S.length()==0)
            return 0;
        int res = 0;
        for(int i=0; i<2*S.length()+1; i++) {
            int left = i/2;
            int right = left + i%2;
            while(left>=0 && right<S.length() && S.charAt(left)==S.charAt(right)) {
                res++;
                left--;
                right++;
            }
        }
        return res;
    }
}
