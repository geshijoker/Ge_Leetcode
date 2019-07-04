class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n<1 || k<1) return res;
        int[] nums = new int[n];
        for(int i=0;i<n;i++) {
            nums[i] = i+1;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        helper(nums, res, temp, k, used, 0);
        return res;
    }
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, int k, boolean[] used, int start) {
        if(temp.size()>=k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<nums.length;i++) {
            if(used[i]) continue;
            temp.add(nums[i]);
            used[i] = true;
            helper(nums, res, temp, k, used, i+1);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
}
