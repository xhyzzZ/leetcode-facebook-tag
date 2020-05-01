//leetcode 209 Minimum Size Subarray Sum

/*
time: O(n)
space: O(1)
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	if (s < 0 || nums == null || nums.length == 0) return 0;
        int sum = 0, j = 0, len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                len = Math.min(len, i - j + 1);
                sum -= nums[j++];
            }
        }
        return (len == Integer.MAX_VALUE) ? 0 : len;
    }
}