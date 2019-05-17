class Solution {
    public boolean canPartition(int[] nums) {
        if(nums==null || nums.length<2)
            return false;
        int sum = 0;
        for (int value : nums) {
            sum += value;
        }
        if(sum%2!=0)
            return false;
        boolean[] dp = new boolean[sum/2+1];
        dp[0] = true;
        int total = 0;
        for(int i=0;i<nums.length;i++) {
            boolean[] dpT = dp.clone();
            for(int j=Math.max(0,total-nums[i]);j+nums[i]<=sum/2;j++) {
                dpT[j+nums[i]] = dp[j] || dpT[j+nums[i]];
                if(dpT[j+nums[i]])
                    total = Math.max(total,j+nums[i]);
            }
            dp = dpT;
        }
        return dp[sum/2];
    }
}
