class Solution {
    public void reverseString(char[] s) {
        helper(s, 0);
    }
    public void helper(char[] s, int i) {
        if(s==null || i>=s.length-1) return;
        for(int j=0;j<s.length-i-1;j++) {
            char tmp = s[j];
            s[j] = s[j+1];
            s[j+1] = tmp;
        }
        helper(s, i+1);
    }
}
