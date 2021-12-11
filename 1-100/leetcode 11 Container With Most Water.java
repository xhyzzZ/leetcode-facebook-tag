// leetcode 11 Container With Most Water

/*
time: O(n)
space: O(1)
*/

public class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
        	res = Math.max(res, Math.min(height[l], height[r]) * (r - l)); //面积
            // area formed between the lines will always be limited by the height of the shorter line
        	if (height[l] < height[r]) {
        		l++;
        	} else r--;
        }
        return res;
    }
}