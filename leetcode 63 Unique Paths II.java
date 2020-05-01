//leetcode 63 Unique Paths II


/*
time: O(m * n)
space: O(n)

This is a typical 2D DP problem, we can store value in 2D DP array, 
but since we only need to use value at dp[i - 1][j] and dp[i][j - 1] 
to update dp[i][j], we don't need to store the whole 2D table, 
but instead store value in an 1D array, and update data by 
using dp[j] = dp[j] + dp[j - 1], (where here dp[j] corresponding to the 
dp[i - 1][j]) and dp[j - 1] corresponding to the dp[i][j - 1] in the 2D array)

dp[j]          = dp[j] + dp[j - 1]
dp[i - 1][j]   =       + dp[i][j - 1]

*/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int length = obstacleGrid.length;
	    int[] res = new int[length];
	    res[0] = 1;
	    for (int i = 0; i < obstacleGrid.length; i++) {
	      	for (int j = 0; j < obstacleGrid[0].length; j++) {
	      		if (obstacleGrid[i][j] == 1) {
	      			res[j] = 0;
	      		} else if (j > 0) {
	      			res[j] += res[j - 1];
	      		}
	      	}
	    }
      	return res[length - 1];
    }
} 