// leeetcode 1060 Missing Element in Sorted Array

/*
time: O(logn)
space: O(1)
*/

class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        // If kth missing number is larger than the last element of the array
        if (k > missing(n - 1, nums)) return nums[n - 1] + k - missing(n - 1, nums);

        int left = 0, right = n - 1;
        // find left = right index such that 
        // missing(left - 1) < k <= missing(left)
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (missing(mid, nums) < k) left = mid + 1;
            else right = mid;
        }

        // kth missing number is greater than nums[idx - 1]
        // and less than nums[idx]
        return nums[left - 1] + k - missing(left - 1, nums);
    }

    // Return how many numbers are missing until nums[idx]
    private int missing(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }
}