//leetcode 81 Search in Rotated Sorted Array II


/*
time: O(logn)
space: O(1)
1 1 1 3 1
*/
public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int start = 0; 
        int end = nums.length - 1;
        while (start 
            = end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) return true;

            //if left part is sorted
            if (nums[start] < nums[mid]) {
                if (target < nums[start] || target > nums[mid]) {
                    //target is in rotated part
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[start] > nums[mid]) {
                //right part is rotated
                
                //target is in rotated part
                if (target < nums[mid] || target > nums[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                //duplicates, we know nums[mid] != target, so nums[start] != target
                //based on current inf ormation, we can only move left pointer to skip one cell
                //thus in the worest case, we would have target: 2, and array like 11111111, then
                //the running time would be O(n)
                start++;
            }
        }
        return false;
    }
}