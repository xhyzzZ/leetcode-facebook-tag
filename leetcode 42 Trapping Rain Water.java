//leetcode 42 Trapping Rain Water

/*
time: O(n)
space; O(1)
*/

public class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            // leftmax is smaller than rightmax, so the (leftmax-A[a]) 
            // water can be stored
        	if (height[left] < height[right]) {
        		leftMax = Math.max(height[left], leftMax);
        		res += leftMax - height[left];
        		left++;
        	} else {
        		rightMax = Math.max(height[right], rightMax);
        		res += rightMax - height[right];
        		right--;
        	}
        }
        return res;
    }
}