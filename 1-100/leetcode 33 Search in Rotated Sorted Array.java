// leetcode 33 Search in Rotated Sorted Array

/* 
time: O(logn)
space: O(1)

You use while (start <= end) if you are returning the match from inside the loop.

You use while (start < end) if you want to exit out of the loop first, 
and then use the result of start or end to return the match.
*/ 
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // the left half is monotonic, yet still does not satisfy
                /* 3 4 5 6 0 1 2 */
                if (nums[left] <= nums[mid] && nums[left] > target) { 
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // the right half is monotonic, yet still does not satisfy
                /* 4 5 6 0 1 2 3*/
                if (nums[right] >= nums[mid] && nums[right] < target) { 
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}