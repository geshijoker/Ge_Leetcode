class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <2 || k <= 0) {
            return false;
        }
        TreeSet<Long> ts = new TreeSet<>(); 
        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            Long floor = ts.floor((long)num);
            Long ceil = ts.ceiling((long)num);
            if ((floor != null && num - floor <= t)
                    || (ceil != null && ceil - num <=t)) {
                return true;
            }

            ts.add((long)(num));
            if (i >= k) {
                ts.remove((long)(nums[i - k]));
            }
        }
        return false;
    }
}
