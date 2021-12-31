// leetcode 920 Number of Music Playlists

/*
time: O(n*goal)
space: O(n*goal)
*/

class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        int MOD = 1_000_000_007;

        // Let dp[i][j] be the number of playlists of length i that have exactly j unique songs. 
        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
        	for (int j = 1; j <= n; j++) {
                dp[i][j] += dp[i - 1][j - 1] * (n - j + 1);
                dp[i][j] += dp[i - 1][j] * Math.max(j - k, 0);
                dp[i][j] %= MOD;
            }
        }
        return (int) dp[goal][n];
    }
}