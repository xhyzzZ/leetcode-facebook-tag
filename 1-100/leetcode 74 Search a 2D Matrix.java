//leetcode 74 Search a 2D Matrix

/*
time: O(logmn)
space: O(logmn)
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row_num = matrix.length;
		int col_num = matrix[0].length;
		
		int begin = 0, end = row_num * col_num - 1;
		
		while(begin <= end){
			int mid = (end  - begin) / 2 + begin;
			int mid_value = matrix[mid / col_num][mid % col_num];
			
			if(mid_value == target) {
				return true;
			
			} else if(mid_value < target) {
				//Should move a bit further, otherwise dead loop.
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
    }
}