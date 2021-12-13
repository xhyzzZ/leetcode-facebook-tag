// leetcode 852 Peak Index in a Mountain Array

/*
time: O(logn)
space: O(1)
*/

public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] < arr[mid + 1]) left = mid + 1;
            else if (arr[mid] < arr[mid - 1]) right = mid - 1;
            else return mid;
        }
        return 0;
    }
}