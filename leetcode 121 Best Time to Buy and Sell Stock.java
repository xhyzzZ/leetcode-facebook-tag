//leetcode 121 Best Time to Buy and Sell Stock

public int maxProfit(int [] prices) {
	int maxCur = 0, maxsSoFar = 0;
	for (i = 1; i < prices.length; i++) {
		maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
		maxsSoFar = Math.max(maxCur, maxsSoFar);
	}
	return maxsSoFar;
}