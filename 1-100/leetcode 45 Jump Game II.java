//leetcode 45 Jump Game II


/*
time: O(n)
space: O(1)

*/

public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int res = 0;
        int curMaxArea = 0;
        int maxNext = 0;
        for(int i = 0; i < nums.length - 1; i++) {
        	maxNext = Math.max(maxNext, i + nums[i]);
        	if(i == curMaxArea) {
        		res++;
        		curMaxArea = maxNext;
        	}
        }
        return res;
    }
}