//leetcode 53 Maximum Subarray

/*
time: O(n)
space: O(n)
*/
public int maxSubArray(int[] A) {
	int n = A.length;
	int[] dp = new int[n];
	dp[0] = a[0];
	int max = dp[0];

	for (int i = 1; i < n ; i++) {
	    dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
	    max = Math.max(max, dp[i]); 
	}

	return max;
}

/*
time: O(n)
space: O(1)
*/

public static int maxSubArray(int[] A) {
    int maxSoFar = A[0], maxEndingHere = A[0];
    for (int i = 1; i < A.length; ++i) {
    	maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
    	maxSoFar = Math.max(maxSoFar, maxEndingHere);	
    }
    return maxSoFar;
}