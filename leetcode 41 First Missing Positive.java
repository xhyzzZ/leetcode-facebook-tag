//leetcode 41 First Missing Positive

/*
time: O(n)
space: O(1)
*/
public class Solution {
	public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)  return i + 1;
        }
        return nums.length + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length; 
    	// [3, 4, -1, 1] -> [3, 4, 5, 1]
	    // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1) 
	    // (we can ignore those because if all number are > n then we'll simply return 1)
	    for (int i = 0; i < n; i++) {
	        if (nums[i] <= 0 || nums[i] > n) {
	            nums[i] = n + 1;
	        }
	    }
	    // note: all number in the array are now positive, and on the range 1..n+1
	    // [3, 4, 5, 1] -> [2, 3, 5, 0] -> [0, 3, -2, 0]
	    // 2. mark each cell appearing in the array, by converting the index for that number to negative
	    for (int i = 0; i < n; i++) {
	        int num = Math.abs(nums[i]);
	        if (num > n) {
	            continue;
	        }
	        num--; // -1 for zero index based array (so the number 1 will be at pos 0)
	        if (nums[num] > 0) { // prevents double negative operations
	            nums[num] = -1 * nums[num];
	        }
	    }
	    
	    // 3. find the first cell which isn't negative (doesn't appear in the array)
	    for (int i = 0; i < n; i++) {
	        if (nums[i] >= 0) {
	            return i + 1;
	        }
	    }
	    
	    // 4. no positive numbers were found, which means the array contains all numbers 1..n
	    return n + 1;
    }
}