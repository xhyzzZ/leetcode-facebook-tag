// leetcode 416 Partition Equal Subset Sum

/*
time: O(2^n)
space: O(n)
*/

brute Force
class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        // if total is odd,it cannot be partitioned into equal sum subset
        if (total % 2 != 0) return false;
        int subSetSum = total / 2;
        int len = nums.length;
        return dfs(nums, len - 1, subSetSum);
    }

    public boolean dfs(int[] nums, int len, int subSetSum) {
        // Base Cases
        if (subSetSum == 0) return true;
        if (len == 0 || subSetSum < 0) return false;
        // isSum (subSetSum, len) = isSum(subSetSum- nums[len], len-1) ||  isSum(subSetSum, len-1)
        return dfs(nums, len - 1, subSetSum - nums[len - 1]) || dfs(nums, len - 1, subSetSum);
    }
}

/*
time: O(n * subSetSum)
space: O(n * subSetSum)
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        // if total is odd, it cannot be partitioned into equal sum subset
        if (total % 2 != 0) return false;
        int subSetSum = total / 2;
        int len = nums.length;
        Boolean[][] memo = new Boolean[len + 1][subSetSum + 1];
        return dfs(nums, len - 1, subSetSum, memo);
    }

    public boolean dfs(int[] nums, int len, int subSetSum, Boolean[][] memo) {
        // Base Cases
        if (subSetSum == 0) return true;
        if (len == 0 || subSetSum < 0) return false;
        // check if subSetSum for given len is already computed and stored in memo
        if (memo[len][subSetSum] != null) return memo[len][subSetSum];
        boolean res = dfs(nums, len - 1, subSetSum - nums[len - 1], memo) 
            || dfs(nums, len - 1, subSetSum, memo);
        memo[len][subSetSum] = res;
        return res;
    }
}

/*
time: O(n * subSetSum)
space: O(n * subSetSum)
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        // if total is odd, it cannot be partitioned into equal sum subset
        if (total % 2 != 0) return false;
        int subSetSum = total / 2;
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][subSetSum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len; i++) {
            int curr = nums[i - 1];
            for (int j = 0; j <= subSetSum; j++) {
                if (j < curr) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - curr]);
                }
            }
        }
        return dp[len][subSetSum];
    }
}

/*
time: O(n * subSetSum)
space: O(subSetSum)
*/

class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return false;
        int total = 0;
        for (int num : nums) total += num;
        // if total is odd, it cannot be partitioned into equal sum subset
        if (total % 2 != 0) return false;
        int subSetSum = total / 2;
        boolean[] dp = new boolean[subSetSum + 1];
        dp[0] = true;
        for (int curr : nums) {
            for (int j = subSetSum; j >= curr; j--) {
                dp[j] |= dp[j - curr];
            }
        }
        return dp[subSetSum];
    }
}