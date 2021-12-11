// leetcode 74 Search a 2D Matrix

/*
time: O(logmn)
space: O(1)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int pivotElement = matrix[mid / n][mid % n];
            if (target == pivotElement)
                return true;
            else {
                if (target < pivotElement) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}