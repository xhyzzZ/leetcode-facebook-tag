// leeetcode 1060 Missing Element in Sorted Array

/*
time: O(logn)
space: O(1)
*/

class Solution {
    public int missingElement(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        // ceiling
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            // amount missing on left
            int missingOnLeft = nums[mid] - nums[0] - mid;
            if (missingOnLeft == k) break;
            else if (missingOnLeft < k) low = mid + 1;
            else high = mid - 1;
        }
        low--; // previous index
        int missingOnLeft = nums[low] - nums[0] - low;
        return nums[low] + k - missingOnLeft;
    }
}