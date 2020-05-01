//leetcode 221 Maximal Square

/*
time: O(m * n)
space: O(m * n)
dp[i][j] 代表在以i, j这一格为右下角的正方形边长。
如果这一格的值也是1，那这个正方形的边长就是他的上面，左手边，和斜上的值的最小边长 +1。
因为如果有一边短了缺了，都构成不了正方形。
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        int maxEdge = 0;
        for (int i = 1; i <= m; i++) {
        	for (int j = 1; j <= n; j++) {
        		if (matrix[i -`1][j - 1] == '1') {
        			dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
        			maxEdge = Math.max(maxEdge, dp[i][j]);
        		}
        	}
        }
        return maxEdge * maxEdge;
    }
}