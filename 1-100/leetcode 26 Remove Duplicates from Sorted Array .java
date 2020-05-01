//leetcode 26 Remove Duplicates from Sorted Array


//time: O(n)
//space: O(1)
public class Solution {
	public int removeDuplicates(int[] nums) {
		int i = 0;
	    for (int n : nums) {
	        if (i < 1 || n > nums[i - 1]) {
	            nums[i] = n;
	            i++;
	        }
	    }
	    return i;
	}
}