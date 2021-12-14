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
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            // Initialize the map.
            dp[i] = new HashMap<Integer, Integer>();
        }
        for (int i = 1; i < nums.length; ++i) {
            int x = nums[i];
            // Iterate over values to the left of i.
            for (int j = 0; j < i; j++) {
                int y = nums[j];
                int d = x - y;  
                // We at least have a minimum chain length of 2 now,
                // given that (nums[j], nums[i]) with the difference d, 
                // by default forms a chain of length 2.
                int len = 2;   
                if (dp[j].containsKey(d)) {
                    // At index j, if we had already seen a difference d,
                    // then potentially, we can add nums[i] to the same chain
                    // and extend it by length 1.
                    len = dp[j].get(d) + 1;
                }
                // Obtain the maximum chain length already seen so far at index i 
                // for the given differene d;
                int curr = dp[i].getOrDefault(d, 0);
                // Update the max chain length for difference d at index i.
                dp[i].put(d, Math.max(curr, len));
                // Update the global max.
                longest = Math.max(longest, dp[i].get(d));
            }
        }
        return longest;
    }
}