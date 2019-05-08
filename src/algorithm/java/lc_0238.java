class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null || nums.length<2)
            return nums;
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int temp = 1;
        for(int i=1;i<nums.length;i++) {
            temp = temp * nums[i-1];
            res[i] *= temp;
        }
        temp = 1;
        for(int i=nums.length-2;i>=0;i--) {
            temp = temp * nums[i+1];
            res[i] *= temp;
        }
        return res;
    }
}
