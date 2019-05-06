class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null)
            return 0;
        if(nums.length==1)
            return nums[0];
        int length = nums.length;
        int[][] dp = new int[2][length];
        int pos = Integer.MIN_VALUE;
        int neg = Integer.MIN_VALUE;
        if(nums[0]>0) {
            dp[0][0] = nums[0];
            pos = nums[0];
        }
        else {
            dp[1][0] = nums[0];
            neg = nums[0];
        }
        for (int i=0;i<length-1; i++) {
            int num = nums[i+1];
            dp[0][i+1] = num > 0 ? dp[0][i] * num : dp[1][i] * num;
            dp[0][i+1] = Math.max(dp[0][i+1], num);
            dp[1][i+1] = num > 0 ? dp[1][i] * num : dp[0][i] * num;
            dp[1][i+1] = Math.min(dp[1][i+1], num);
            pos = Math.max(pos, dp[0][i+1]);
            neg = Math.max(neg, dp[1][i+1]);
        }
        if(pos>0)
            return pos;
        else
            return neg;
    }
}
