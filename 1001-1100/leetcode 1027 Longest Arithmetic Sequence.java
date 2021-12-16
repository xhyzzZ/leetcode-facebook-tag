// leetcode 1027 Longest Arithmetic Sequence

/*
time: O(n^2)
space: O(n^2)
*/

class Solution {
	public int longestArithSeqLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int longest = 0;
        // Declare a dp array that is an array of hashmaps.
        // The map for each index maintains an element of the form-
        //   (difference, length of max chain ending at that index with that difference).    
        // dp[index][diff] equals to the length of arithmetic sequence at index with difference diff    
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // Initialize the map.
            dp[i] = new HashMap<Integer, Integer>();
        }
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            // Iterate over values to the left of i.
            for (int j = 0; j < i; j++) {
                int y = nums[j];
                int diff = x - y;  
                // We at least have a minimum chain length of 2 now,
                // given that (nums[j], nums[i]) with the difference diff, 
                // by default forms a chain of length 2.
                int len = 2;   
                if (dp[j].containsKey(diff)) {
                    // At index j, if we had already seen a difference diff,
                    // then potentially, we can add nums[i] to the same chain
                    // and extend it by length 1.
                    len = dp[j].get(diff) + 1;
                }
                // Obtain the maximum chain length already seen so far at index i 
                // for the given differene diff;
                int curr = dp[i].getOrDefault(diff, 0);
                // Update the max chain length for difference diff at index i.
                dp[i].put(diff, Math.max(curr, len));
                // Update the global max.
                longest = Math.max(longest, dp[i].get(diff));
            }
        }
        return longest;
    }
}