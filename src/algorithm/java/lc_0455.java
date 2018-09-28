class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g==null || g.length==0 || s==null || s.length==0)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        int res = 0;
        while(i<g.length && j<s.length) {
            if(s[j]>=g[i]) {
                res++;
                i++;
                j++;
            }else {
                j++;
            }
        }
        return res;
    }
}
