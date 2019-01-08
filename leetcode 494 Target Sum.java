//leetcode 494 Target Sum

/*
time: O(n * sum)
space: O(n * sum) -> O(sum)
*/

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0; 
        for(int i : nums) sum += i;
        if(S > sum || S <- sum) return 0;
        int[] dp = new int[2 * sum + 1];
        dp[0 + sum] = 1;
        for(int i = 0; i < nums.length; i++) {
            int[] next = new int[2 * sum + 1];
            for(int k = 0; k < 2 * sum + 1; k++) {
                if(dp[k] != 0) {
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum + S];
    }
}