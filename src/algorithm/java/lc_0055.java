class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0)
            return false;
        int n = nums.length;
        int reach = 0;
        for(int i=0;i<n && i<=reach;i++) {
            reach = Math.max(i+nums[i], reach);
        }
        return reach>=n-1;        
    }
}
