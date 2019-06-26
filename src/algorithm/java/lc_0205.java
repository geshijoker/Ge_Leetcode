class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char sC = s.charAt(i), tC = t.charAt(i);
            if(map.containsKey(sC) && map.get(sC)!=tC) {
                return false;
            }
            map.putIfAbsent(sC, tC);
        }
        map.clear();
        for(int i=0;i<s.length();i++) {
            char sC = s.charAt(i), tC = t.charAt(i);
            if(map.containsKey(tC) && map.get(tC)!=sC) {
                return false;
            }
            map.putIfAbsent(tC, sC);
        }
        return true;
    }
}
