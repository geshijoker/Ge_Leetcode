class Solution {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length<2)
            return;
        int cur = nums.length-1;
        int min = nums[cur];
        for(cur=nums.length-1;cur>0;cur--) {
            if(nums[cur-1]<nums[cur]) {
                break;
            }
        }
        System.out.println(cur);
        if(cur!=0) {
            for(int i=cur; i<nums.length; i++) {
                if(nums[i]<=nums[cur-1]) {
                    int temp = nums[cur-1];
                    nums[cur-1] = nums[i-1];
                    nums[i-1] = temp;
                    break;
                }
                if(i==nums.length-1) {
                    int temp = nums[cur-1];
                    nums[cur-1] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }
        for(int i=cur; i<(nums.length+cur)/2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length+cur-i-1];
            nums[nums.length+cur-i-1] = temp;
        }
        return;
    }
}
