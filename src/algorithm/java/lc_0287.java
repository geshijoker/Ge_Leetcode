class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        int find=0;
        
        while (true)
         {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast)
                break;
         }
        while (true)
        {
            slow = nums[slow];
            find = nums[find];
            if (slow == find)
                return slow;
        }
    }
}
