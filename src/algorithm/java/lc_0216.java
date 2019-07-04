class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(k<1 || n<1) return res;
        int[] nums = new int[9];
        for(int i=0; i<9;i++) {
            nums[i] = i+1;
        }
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, res, temp, n, 0, k, used);
        return res;
    }
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, int remain, int start, int k, boolean[] used) {
        if(start > nums.length) return;
        if(remain == 0 && temp.size()==k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<nums.length;i++) {
            if(used[i]) continue;
            temp.add(nums[i]);
            used[i] = true;
            helper(nums, res, temp, remain-nums[i], i+1, k, used);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
}
