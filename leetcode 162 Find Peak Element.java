//leetcode 162 Find Peak Element

/*
time: O(logn)
space: O(1)
Lets say you have a mid number at index x, nums[x]
if (num[x+1] > nums[x]), that means a peak element HAS to 
exist on the right half of that array, because (since every number is unique) 
1. the numbers keep increasing on the right side, and the peak will be the 
last element. 
2. the numbers stop increasing and there is a 'dip', 
or there exists somewhere a number such that nums[y] < nums[y-1], 
which means number[x] is a peak element.

This same logic can be applied to the left hand side (nums[x] < nums[x-1]).
规律一：如果nums[i] > nums[i+1]，则在i之前一定存在峰值元素
规律二：如果nums[i] < nums[i+1]，则在i+1之后一定存在峰值元素
*/
public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
        	int mid = (right - left) / 2 + left;
        	if (nums[mid] > nums[mid + 1]) {
        		right = mid;
        	} else left = mid + 1;
        }
        return left;
    }
}