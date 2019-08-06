//leetcode 162 Find Peak Element

/*
time: O(logn)
space: O(1)
规律一：如果nums[i] > nums[i+1]，则在i之前一定存在峰值元素
规律二：如果nums[i] < nums[i+1]，则在i+1之后一定存在峰值元素
*/
public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
        	int mid = (right - left) / 2 + left;
        	if (nums[mid] > nums[mid + 1]) right = mid;
        	else left = mid + 1;
        }
        return left;
    }
}