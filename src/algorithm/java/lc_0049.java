class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strs) {
            String key = getSorted(str);
            if(!map.containsKey(key)) map.put(key, new LinkedList<String>());
             map.get(key).add(str);
        }
        return new LinkedList<List<String>>(map.values());
    }
    String getSorted(String s)  {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
