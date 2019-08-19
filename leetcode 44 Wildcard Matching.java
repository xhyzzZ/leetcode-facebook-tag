//leetcode 44 Wildcard Matching



/*
time: O(n)
space: O(1)
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();  
        int n = p.length();  
        boolean[][] dp = new boolean[m + 1][n + 1];  
        dp[0][0] = true;  

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
        }  

        for (int i = 1; i <= m; i++) {  
            for (int j = 1; j <= n; j++) {  
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];  
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }      
            }  
        }  
        return dp[m][n];  
    }
}

public class Solution {
    public boolean isMatch(String s, String p) {
        int sp = 0;
        int pp = 0;
        int match = 0;
        int star = -1;
        while (sp < s.length()) {
        	if (pp < p.length() && (s.charAt(sp) == p.charAt(pp)) || p.charAt(pp) == '?') {
        		sp++;
        		pp++;
        	} else if (pp < p.length() && p.charAt(pp) == '*') {
        		star = pp;
        		match = sp;
        		pp++;
        	} else if (star != -1) {
        		pp = star + 1;
        		match++;
        		sp = match;
        	} else return false;
        }
        while (pp < p.length() && p.charAt(pp) == '*') {
        	pp++;
        }
        return pp == p.length();
    }
}