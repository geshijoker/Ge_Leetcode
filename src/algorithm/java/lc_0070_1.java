class Solution {
    Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if(n<2) return 1;
        if(cache.containsKey(n)) return cache.get(n);
        int res = climbStairs(n-1) + climbStairs(n-2);
        cache.put(n, res);
        return res;
    }
}
