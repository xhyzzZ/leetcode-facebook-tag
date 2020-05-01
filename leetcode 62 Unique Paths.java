//leetcode 62 Unique Paths

/*
time: O(n * m)
space: O(n * m)
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
            }
        }
        return grid[m - 1][n - 1];
    }
}

/*
time: O(n * m)
space: O(n)
*/

public class Solution {
    public int uniquePaths(int m, int n) {	
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 0; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		res[j] += res[j - 1];
            }
        }
        return res[n - 1];
    }
}

/*
time: O(m * n) 
space: O(1)
*/
public class Solution {
    public int uniquePaths(int m, int n) {
        int count = m + n - 2;
        int k = m - 1;
        double res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (count - k + 1) / i;
        }
        return (int)res;
    }
}