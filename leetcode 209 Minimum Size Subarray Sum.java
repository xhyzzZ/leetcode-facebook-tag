//leetcode 209 Minimum Size Subarray Sum

/*
time: O(n)
space: O(1)
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	if (s < 0 || nums == null || nums.length == 0) return 0;
        int size = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < s) {
                sum += nums[j++];
            }
            if (sum >= s) size = Math.min(j - i, size);
            sum -= nums[i];
        }
        if (size == Integer.MAX_VALUE) return 0;

        return size;
    }
}