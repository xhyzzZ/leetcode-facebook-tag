// leetcode 562 Longest Line of Consecutive One in Matrix

/*
time: O(mn)
space: O(mn)
*/

class Solution {
    public int longestLine(int[][] mat) {
        if (mat.length == 0) return 0;
        int ones = 0;
        // dp[0], dp[1], dp[2] , dp[3] are used to store the maximum number of 
        // continuous 1's found so far along the Horizontal, Vertical, Diagonal and Anti-diagonal lines
        int[][][] dp = new int[mat.length][mat[0].length][4];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j][0] = j > 0 ? dp[i][j - 1][0] + 1 : 1;
                    dp[i][j][1] = i > 0 ? dp[i - 1][j][1] + 1 : 1;
                    dp[i][j][2] = (i > 0 && j > 0) ? dp[i - 1][j - 1][2] + 1 : 1;
                    dp[i][j][3] = (i > 0 && j < mat[0].length - 1) ? dp[i - 1][j + 1][3] + 1 : 1;
                    ones = Math.max(ones, Math.max(Math.max(dp[i][j][0], dp[i][j][1]), Math.max(dp[i][j][2], dp[i][j][3])));
                }
            }
        }
        return ones;
    }
}