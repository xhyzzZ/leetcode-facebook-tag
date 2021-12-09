// leetcode 300 Longest Increasing Subsequence

/*
time: O(n^2)
space: O(n)
*/

class Solution {
	// dp[i] represents the length of the longest increasing subsequence that ends with the element at index i
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int longest = 0;
        for (int c : dp) {
            longest = Math.max(longest, c);
        }
        
        return longest;
    }
}

/*
time: O(nlogn)
space; O()
*/

public class Solution {
	public int lengthOfLIS(int[] nums) {
	    int[] tails = new int[nums.length];
	    int size = 0;
	    for (int x : nums) {
	        int i = 0, j = size;
	        while (i != j) {
	            int m = (i + j) / 2;
	            if (tails[m] < x)
	                i = m + 1;
	            else
	                j = m;
	        }
	        tails[i] = x;
	        if (i == size) ++size;
	    }
	    return size;
	}
}