// leetcode 494 Target Sum

/*
time: O(2^n)
space: O(n)
*/

// https://leetcode.com/problems/target-sum/discuss/455024/DP-IS-EASY!-5-Steps-to-Think-Through-DP-Questions.
brute force
public class Solution {
    int count = 0;
    
    public int findTargetSumWays(int[] nums, int target) {
        calculate(nums, 0, 0, target);
        return count;
    }
    
    private void calculate(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            calculate(nums, i + 1, sum + nums[i], target);
            calculate(nums, i + 1, sum - nums[i], target);
        }
    }
}

/*
time: O(n * sum)
space: O(n * sum)
*/

recursive + memo
public class Solution {
    private int total;
    
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        
        int[][] memo = new int[nums.length][2 * total + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dfs(nums, 0, 0, target, memo);
    }
    
    public int dfs(int[] nums, int i, int sum, int target, int[][] memo) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        } else {
            if (memo[i][sum + total] != Integer.MIN_VALUE) {
                return memo[i][sum + total];
            }
            int add = dfs(nums, i + 1, sum + nums[i], target, memo);
            int subtract = dfs(nums, i + 1, sum - nums[i], target, memo);
            memo[i][sum + total] = add + subtract;
            return memo[i][sum + total];
        }
    }
}

/*
time: O(n * sum)
space: O(n * sum) -> O(sum)
*/

dp
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2 * total + 1];
        dp[0][nums[0] + total] = 1;
        dp[0][-nums[0] + total] += 1;
        
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -total; sum <= total; sum++) {
                if (dp[i - 1][sum + total] > 0) {
                    dp[i][sum + nums[i] + total] += dp[i - 1][sum + total];
                    dp[i][sum - nums[i] + total] += dp[i - 1][sum + total];
                }
            }
        }
        
        return Math.abs(target) > total ? 0 : dp[nums.length - 1][target + total];
    }
}