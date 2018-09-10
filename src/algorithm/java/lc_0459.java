class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int i=1;i<s.length()/2+1;i++) {
            String subs = s.substring(0, i);
            int subsLength = i;
            if(s.length() % subsLength!=0)
                continue;
            int k = i;
            while(k+i<=s.length() && subs.equals(s.substring(k, k+i))){
                k+=i;
            }
            if(k==s.length() && subs.equals(s.substring(k-i, k)))
                return true;
        }
        return false;
    }
}
