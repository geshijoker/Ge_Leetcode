class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length<1) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        helper(nums, res, temp, 0, used);
        return res;
    }
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, int start, boolean[] used) {
        res.add(new ArrayList<>(temp));
        if(start>=nums.length) {
            return;
        }
        for(int i=start;i<nums.length;i++) {
            if(used[i]) continue;
            temp.add(nums[i]);
            used[i] = true;
            helper(nums, res, temp, i+1, used);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
}
