//leetcode 300 Longest Increasing Subsequence

/*
time: O(n^2)
space: O()
*/

public class Solution {
    public int lengthOfLIS(int[] nums) {
        // Base case
		if (nums.length <= 1) return nums.length;
		// This will be our array to track longest sequence length
		int[] T = new int[nums.length];
		// Fill each position with value 1 in the array
		for (int i = 0; i < nums.length; i++) {
			T[i] = 1;
		}
		// Mark one pointer at i. For each i, start from j=0.
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				// It means next number contributes to increasing sequence.
				if (nums[j] < nums[i]) {
					// But increase the value only if it results in a larger value of the sequence than T[i]
					// It is possible that T[i] already has larger value from some previous j'th iteration
					if (T[j] + 1 > T[i]) {
						T[i] = T[j] + 1;
					}
				}
			}
		}
		// Find the maximum length from the array that we just generated 
		int longest = 0;
		for (int i = 0; i < T.length; i++) {
			longest = Math.max(longest, T[i]);
		}
		return longest;
    }



/*
time: O(nlogn)
space; O()
*/
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