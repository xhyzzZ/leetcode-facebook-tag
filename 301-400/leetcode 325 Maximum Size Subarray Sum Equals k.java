// leetcode 325 Maximum Size Subarray Sum Equals k

/*
time: O(n)
space: O(n)
*/

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int curSum = 0, max = 0;
        // key: cumulative sum until index i, value: i
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	    for (int i = 0; i < nums.length; i++) {
	        curSum =+ nums[i];

	        // cumulative sum is k, update maxLen for sure
	        if (curSum == k) {
	            max = i + 1;
	        } else if (map.containsKey(curSum - k)) {
	        	// cumulative sum is more than k, but we can truncate a prefix of the array
	            max = Math.max(max, i - map.get(curSum - k));
	        }

	        // store cumulative sum in map, only if it is not seen
            // because only the earlier (thus shorter) subarray is valuable, when we want to get the maxLen after truncation
	        if (!map.containsKey(curSum)) {
	            map.put(curSum, i);
	        }
	    }
	    return max;
    }
}