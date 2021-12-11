// leetcode 322 Coin Change

/*
time: O(n * amount)
space: O(n)
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
       	// dp[n] = min number of coins to make amount n;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		// no money no coin
		dp[0] = 0;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}
		return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}

public class Solution {
    int minCount = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
       	Arrays.sort(coins);
		count(amount, coins.length - 1, coins, 0);
		return minCount == Integer.MAX_VALUE ? -1: minCount;
    }
	private void count(int amount, int index, int[] coins, int count) {
	    if (index < 0 || count + 2 > minCount) return;
		for (int i = amount / coins[index]; i >= 0; i--) {
			int newAmount = amount - i * coins[index];
			int newCount = count + i;
			if (newAmount > 0 && newCount + 1 < minCount) 
			    count(newAmount, index - 1, coins, newCount);
			else {
			    if (newAmount == 0 && newCount < minCount)
			        minCount = newCount;
			    break;
			}
		}
	}
}