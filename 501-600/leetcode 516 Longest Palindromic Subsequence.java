// leetcode 516 Longest Palindromic Subsequence

/*
time: O(n^2)
space: O(n^2)
*/

dp
class Solution {
    public int longestPalindromeSubseq(String s) {
        // dp[i][j]: the longest palindromic subsequence's length of substring(i, j), 
        // here i, j represent left, right indexes in the string
        // State transition:
        // dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
        // otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
        // Initialization: dp[i][i] = 1
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

/*
time: O(n^2)
space: O(n^2)
*/

recursion + memo
public class Solution {
    public int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }
    
    private int helper(String s, int start, int end, Integer[][] memo) {
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        if (start > end) return 0;
        if (start == end) return 1;
        
        if (s.charAt(start) == s.charAt(end)) {
            memo[start][end] = helper(s, start + 1, end - 1, memo) + 2;
        } else {
            memo[start][end] = Math.max(helper(s, start + 1, end, memo), helper(s, start, end - 1, memo));
        }
        return memo[start][end];
    }
}

