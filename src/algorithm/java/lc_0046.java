class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        helper(nums, res, temp, used);
        return res;
    }
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] used){
        if(temp.size()>= nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(used[i]) continue;
            temp.add(nums[i]);
            used[i] = true;
            helper(nums, res, temp, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
