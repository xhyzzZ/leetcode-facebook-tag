//leetcode 852 Peak Index in a Mountain Array

/*
time: O(logn)
space: O(1)
*/

public class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            if(A[mid] < A[mid + 1]) left = mid + 1;
            else if(A[mid] < A[mid - 1]) right = mid - 1;
            else return mid;
        }
        return 0;
    }
}