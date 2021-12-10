// leetcode 698 Partition to K Equal Sum Subsets

/*
time: O(k * 2^n)
space: O(n)
*/

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, 0, 0, visited, sum / k, k);
    }

    public boolean canPartition(int[] nums, int sum, int start, boolean[] visited, int target, int k) {
        // means you already found k - 1 subsets with target sum
        if (k == 1) return true;

        if (sum == target) {
            return canPartition(nums, 0, 0, visited, target, k - 1);
        }
            
        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && sum + nums[i] <= target) {
                visited[i] = true;
                if (canPartition(nums, sum + nums[i], i + 1, visited, target, k)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        // We were not able to make a valid combination after picking each element from the array,
        // hence we can't make k subsets.

        return false;
    }
}
