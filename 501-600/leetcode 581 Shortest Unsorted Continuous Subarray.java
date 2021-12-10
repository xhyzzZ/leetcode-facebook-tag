// leetcode 581 Shortest Unsorted Continuous Subarray

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        
        int start = 0;
        while (start < n  && nums[start] == temp[start]) start++;
        
        int end = n - 1;
        while (end > start  && nums[end] == temp[end]) end--;
        
        return end - start + 1;
    }
}

/*
time: O(n)
space: O(1)
*/

class Solution {
	public int findUnsortedSubarray(int[] nums) {
	    int l = 0, r = nums.length - 1;
	    
	    while (l < r && nums[l] <= nums[l + 1]) l++;
	        
	    if (l >= r) return 0;
	    
	    while (nums[r] >= nums[r - 1]) r--;
	    
	    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			
	    for (int k = l; k <= r; k++) {
	        max = Math.max(max, nums[k]);
	        min = Math.min(min, nums[k]);
	    }
	    
	    while (l >= 0 && min < nums[l]) l--;
	    while (r < nums.length && nums[r] < max) r++;
	        
	    return (r - l - 1);
	}
}