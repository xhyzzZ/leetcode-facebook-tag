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
space; O(n)
*/

class Solution {
	public int lengthOfLIS(int[] nums) {
	    List<Integer> sequence = new ArrayList<>();
	    for (int n : nums) update(sequence, n);
	    
	    return sequence.size();
	}

	private void update(List<Integer> seq, int n) {
	    if (seq.isEmpty() || seq.get(seq.size() - 1) < n) seq.add(n);
	    else seq.set(findFirstLargeEqual(seq, n), n);
	}

	private int findFirstLargeEqual(List<Integer> seq, int target) {
	    int lo = 0;
	    int hi = seq.size() - 1;
	    while (lo < hi) {
	        int mid = lo + (hi - lo) / 2;
	        if (seq.get(mid) < target) lo = mid + 1;
	        else hi = mid;
	    }
	    return lo;
	}
}