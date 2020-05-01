//leetcode 72 Edit Distance

/*
time: O(m * n)
space: O(m * n)

dp[i][j]表示的是，从字符串1的i的位置转换到字符串2的j的位置，所需要的最少步数

1.字符串字符相等：dp[i][j] = dp[i - 1][j - 1]
2.字符串字符不等：
	insert: dp[i][j - 1] + 1
	replace: dp[i][j] = dp[i - 1][j - 1] + 1
	delete: dp[i][j] = dp[i - 1][j] + 1
*/
    
public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
        	dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
        	dp[0][i] = i;
        }

        for (int i = 1; i <= len1; i++) {
        	for (int j = 1; j <= len2; j++) {
        		if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
        			dp[i][j] = dp[i - 1][j - 1];
        		} else {
        			dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        		}
        	}
        }
        return dp[len1][len2];
    }
}