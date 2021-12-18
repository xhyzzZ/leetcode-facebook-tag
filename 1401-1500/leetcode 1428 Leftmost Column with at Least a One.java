// leetcode 1428 Leftmost Column with at Least a One

/*
time: O(nlogm)
space: O(1)
*/

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);
        int left = 0, right = cols - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (existOneInColumn(binaryMatrix, rows, mid)) {
                ans = mid;          // record as current ans
                right = mid - 1;    // try to find in the left side
            } else {
                left = mid + 1;     // try to find in the right side
            }
        }
        return ans;
    }
    private boolean existOneInColumn(BinaryMatrix binaryMatrix, int rows, int c) {
        for (int r = 0; r < rows; r++) if (binaryMatrix.get(r, c) == 1) return true;
        return false;
    }
}