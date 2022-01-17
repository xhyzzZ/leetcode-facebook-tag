// leetcode 53 Maximum Subarray

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int maxSubArray(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len];
		dp[0] = nums[0];
		int max = dp[0];

		for (int i = 1; i < len ; i++) {
		    dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
		    max = Math.max(max, dp[i]); 
		}

		return max;
	}
}

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];
        
        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }
        
        return maxSubarray;
    }
}