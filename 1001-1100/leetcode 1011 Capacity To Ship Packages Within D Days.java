// leetcode 1011 Capacity To Ship Packages Within D Days

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int weight : weights) {
        	left = Math.max(left, weight);
        	right += weight;
        }

        while (left < right) {
        	int mid = (right - left) / 2 + left, need = 1, cur = 0;
        	for (int weight : weights) {
        		if (cur + weight > mid) {
        			need += 1;
        			cur = 0;
        		}
        		cur += weight;
        	} 
        	if (need > days) left = mid + 1;
        	else right = mid;
        }
        return left;
    }
}