// leetcode 1901 Find a Peak Element II

/*
time: O(nlogm)
space: O(1)
*/

class Solution {
    public int[] findPeakGrid(int[][] mat) {
 		// 1. Pick the middle column.
		// 2. Find the global maximum in the column.
		// 3. If the row-neighbours of this element are smaller, then we found a 2D peak. 
		// Else, we recurse at the right-half of the matrix if the right-neighbour was bigger, 
		// and left-half of the matrix if the left-neighbour was bigger.\


    	// if mat[i][j + 1] > mat[i][j] 
		// then mat[i][j + 1] is bigger than all elements in column j
		// thus maximum of column j + 1 is bigger than its row-neighbour in column j
		// thus, there exists some peak in the right half of the matrix
        int n = mat.length, m = mat[0].length, lo = 0, hi = m - 1, mid; 
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            int max_row = 0;
            for (int i = 0; i < n; i++) {
                if (mat[max_row][mid] < mat[i][mid]) max_row = i;
            }
            if ((mid == 0 || mat[max_row][mid] > mat[max_row][mid - 1]) && 
            	(mid == m - 1 || mat[max_row][mid] > mat[max_row][mid + 1])) return new int[] {max_row, mid};
            else if (mid > 0 && mat[max_row][mid - 1] > mat[max_row][mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return new int[] {-1, -1};
    }
}