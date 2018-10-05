class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int len=0;
        int[] dp=new int[nums.length];
        for(int x:nums){
            int idx=Arrays.binarySearch(dp, 0, len, x);
            System.out.println(idx);
            if(idx<0){
                idx=-(idx+1);
                dp[idx]=x;
            }
            if(len==idx) len++;
        }
        return len;
    }
}
