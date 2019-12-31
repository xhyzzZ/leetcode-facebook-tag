//leetcode 516 Longest Palindromic Subsequence

/*
time: O(n^2)
space: O(n^2)
*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];  
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i - 1) {
                        dp[j][i] = 2;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1] + 2;
                    }
                } else {
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}

public class Solution {
    public int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }
    
    private int helper(String s, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i > j) return 0;
        if (i == j) return 1;
        
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = helper(s, i + 1, j - 1, memo) + 2;
        } else {
            memo[i][j] = Math.max(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
        }
        return memo[i][j];
    }
}

