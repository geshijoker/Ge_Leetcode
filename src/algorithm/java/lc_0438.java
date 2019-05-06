class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s==null || p==null || s.length()==0 || p.length()==0)
            return res;
        int sl = s.length();
        int pl = p.length();
        char[] cano = p.toCharArray();
        Arrays.sort(cano); 
        for(int i=0;i<sl-pl+1;i++) {
            char[] typical = s.substring(i,i+pl).toCharArray();
            Arrays.sort(typical);
            if(Arrays.equals(cano, typical))
                res.add(i);
        }
        return res;
    }
}
