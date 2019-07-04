class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length<1) return res;
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, res, temp, 0, used);
        return res;
    }
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, int start, boolean[] used) {
        res.add(new ArrayList<>(temp));
        if(start>=nums.length) return;
        for(int i=start;i<nums.length;i++) {
            if(used[i] || i>start && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            used[i] = true;
            helper(nums, res, temp, i+1, used);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
}
