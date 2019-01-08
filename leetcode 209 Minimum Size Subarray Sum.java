//leetcode 209 Minimum Size Subarray Sum

/*
time: O(n)
space: O(1)
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < nums.length) {
            while (sum < s && j < nums.length) sum += nums[j++];
            if(sum >= s) {
                while (sum >= s && i < j) sum -= nums[i++];
                min = Math.min(min, j - i + 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}