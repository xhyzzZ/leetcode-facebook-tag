//leetcode 162 Find Peak Element

/*
time: O(logn)
space: O(1)
*/
public class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
        	int mid = (j - i) / 2 + i;
        	if(nums[mid] > nums[mid + 1]) j = mid;
        	else i = mid + 1;
        }
        return i;
    }
}