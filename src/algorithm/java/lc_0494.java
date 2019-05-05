class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int[] row: memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return helper(nums, 0, 0, S, memo);
    }
    public int helper(int[] nums, int index, int sum, int S, int[][] memo) {
        if (index == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        }
        if (memo[index][sum + 1000] != Integer.MIN_VALUE) {
            return memo[index][sum + 1000];
        }
        int add = helper(nums, index + 1, sum + nums[index], S, memo);
        int subtract = helper(nums, index + 1, sum - nums[index], S, memo);
        memo[index][sum + 1000] = add + subtract;
        return memo[index][sum + 1000];
    }
}
