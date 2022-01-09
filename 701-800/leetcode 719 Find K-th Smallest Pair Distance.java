// leetcode 719 Find K-th Smallest Pair Distance

/*
time: O(nlogd + nlogn)
space: O(1)
*/

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
    
	    int len = nums.length;
	    int left = 0;
	    int right = nums[len - 1] - nums[0];
	    
	    for (int cnt = 0; left < right; cnt = 0) {
	        int mid = left + (right - left) / 2;
	        
	        for (int i = 0, j = 0; i < len; i++) {
	            while (j < len && nums[j] <= nums[i] + mid) j++;
	            cnt += j - i - 1;
	        }
	        
	        if (cnt < k) {
	            left = mid + 1;
	        } else {
	            right = mid;
	        }
	    }
	    
	    return left;
    }
}