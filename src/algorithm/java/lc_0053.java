class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum=Integer.MIN_VALUE;
        for(int j=0;j<nums.length;j++) {
            if(sum<0){
                sum = nums[j];
            }
            else {
                sum+=nums[j];
            }
            max = (int) Math.max(sum,max);
        }
        return max;
    }
}
