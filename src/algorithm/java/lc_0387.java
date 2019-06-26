class Solution {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        int[] res = new int[s.length()];
        //int[] intArray = new int[20];
        for(int i=0;i<s.length();i++) {
            char cur = s.charAt(i);
            if(map.containsKey(cur)) {
                res[i] = -1;
                res[map.get(cur)] = -1;
            }
            map.put(cur, i);
        }
        int j = 0;
        while(j<res.length && res[j]==-1) {
            j++;
        }
        if(j>=res.length) return -1;
        return j;
    }
}
