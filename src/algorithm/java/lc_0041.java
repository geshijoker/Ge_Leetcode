class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if(n==0)
            return 1;
        for(int i=0;i<n;i++) {
            while(nums[i]>0 && nums[i]<=n && nums[i]!=i+1) {
                int v = nums[i];
                
                if(nums[i]==nums[v-1])
                    break;
                nums[i] = nums[v-1];
                nums[v-1] = v;
            }
        }
        for(int i=0;i<n;i++) {
            if(nums[i]!=i+1)
                return i+1;
        }
        return  n+1;
    }
}
