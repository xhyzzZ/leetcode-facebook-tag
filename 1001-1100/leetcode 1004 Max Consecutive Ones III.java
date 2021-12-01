// leetcode 1004 Max Consecutive Ones III

/*
time: O(n)
space: O(1)

Intuition
Translation:
Find the longest subarray with at most k zeros.

Explanation
For each nums[j], try to find the longest subarray.
If nums[i] ~ nums[j] has zeros <= k, we continue to increment j.
If nums[i] ~ nums[j] has zeros > k, we increment i.
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int end = 0, start = 0, counter = 0, res = 0;
        while (end < nums.length) {
            if (nums[end] == 0) counter++;
            
            while (counter > k) {
                if (nums[start] == 0) counter--;
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}