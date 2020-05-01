//leetcode 698 Partition to K Equal Sum Subsets

/*
time: O()
space: O()
*/

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, 0, 0, visited, sum / k, k);
    }

    public boolean canPartition(int[] nums, int sum, int start, boolean[] visited, int target, int k) {
        if (k == 1) return true;
        if (sum == target) {
            return canPartition(nums, 0, 0, visited, target, k - 1);
        }
            
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (canPartition(nums, sum + nums[i], i + 1, visited, target, k)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}