// leetcode 935 Knight Dialer

/*
time: O(10*N)
space: O(N)
*/

class Solution {
    public int knightDialer(int n) {
        int[][] map = new int[][] {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int[][] memo = new int[n + 1][10];
        for (int i = 1; i <= n; i++) Arrays.fill(memo[i], -1);
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += helper(n, i, map, memo);
            res %= (int) 1e9 + 7;
        }
        return res;
    }

    private int helper(int n, int start, int[][] map, int[][] memo) {
        if (n == 1) return 1;
        if (memo[n][start] > -1) return memo[n][start];
        memo[n][start] = 0;
        for (int next : map[start]) {
            memo[n][start] += helper(n - 1, next, map, memo);
            memo[n][start] %= (int) 1e9 + 7;
        }
        return memo[n][start];
    }
}