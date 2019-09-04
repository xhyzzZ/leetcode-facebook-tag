//leetcode 518 Coin Change 2

/*
time: O(mn)
space: O(m)
*/

/* dp[i][j] : the number of combinations to make up amount j by using the first i types of coins
State transition:

not using the ith coin, only using the first i-1 coins to make up amount j, 
then we have dp[i-1][j] ways. using the ith coin, since we can use unlimited 
same coin, we need to know how many ways to make up amount j - coins[i-1] 
by using first i coins(including ith), which is dp[i][j-coins[i-1]]
Initialization: dp[i][0] = 1
*/

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
}