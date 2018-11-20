class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, nums.length);
        
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int len) {
        if (len == tmp.size()) {
            res.add(new ArrayList(tmp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            
            tmp.add(nums[i]);
            backtrack(res, tmp, removedArray(nums, i), len);
            tmp.remove(tmp.size()-1);
        }
    }
    
    public int[] removedArray(int[] nums, int x) {
        int[] re = new int[nums.length-1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == x)
                continue;
            else 
                re[j++] = nums[i];
        }
        
        return re;
    }   
}
