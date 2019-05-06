class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int start = 0;
        int end = 0;
        boolean flag = true;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=temp[i]) {
                end = i+1;
                if(flag) {
                    start = i;
                    flag = false;
                }
            }
        }
        return end-start;
    }
}
