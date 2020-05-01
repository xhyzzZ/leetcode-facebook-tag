//leetcode 34 Find First and Last Position of Element in Sorted Array

/*
time: O(logn)
space: O(1)

*/ 
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) return new int[] {-1, -1};
        int[] res = new int[] {-1, -1};
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if(nums[mid] < target) i = mid + 1;
            else j = mid;
        }
        if (nums[i] != target) return res;
        else res[0] = i;

        j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2 + 1;
            if (nums[mid] > target) j = mid - 1;
            else i = mid;
        }
        res[1] = j;
        return res;
    }
}