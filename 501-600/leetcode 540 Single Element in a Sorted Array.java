//leetcode 540 Single Element in a Sorted Array

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        // corner case
		if(nums == null || nums.length == 0) return -1;
		
		int lo = 0;
		int hi = nums.length - 1;
		while(lo < hi) {
			int mid = lo + (hi - lo) / 2;
			// trick here
			// int temp = mid % 2 == 0 ? mid + 1: mid - 1;
			int temp = mid ^ 1; // if even, mid + 1; if odd, mid - 1
			if(nums[mid] == nums[temp]) {
				// if mid is even, then nums[mid] = nums[mid + 1], single number is >= mid + 2
				// if mid is odd, then nums[mid] = nums[mid - 1], single number is >= mid + 1
				// so we choose mid + 1
				lo = mid + 1;
			} else {
				// maybe nums[hi] is the single numer or
				// maybe the single number is to the left of nums[hi]
				// <= hi
				hi = mid; 
			}
		}
		
		return nums[lo];
    }
}