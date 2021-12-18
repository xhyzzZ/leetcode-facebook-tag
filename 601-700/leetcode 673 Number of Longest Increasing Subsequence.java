// leetcode 673 Number of Longest Increasing Subsequence

/*
time: O(n^2)
space: O(n)
*/

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        // length[i]: the length of the Longest Increasing Subsequence which ends with nums[i].
        // count[i]: the number of the Longest Increasing Subsequence which ends with nums[i].
        int[] length = new int[n];
        int[] count = new int[n];
        
        // each number is a subsequence
        Arrays.fill(length, 1);
        // since each number is a subsequence, the LIS for a single element array is 1
        Arrays.fill(count, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (1 + length[j] > length[i]) {
                        length[i] = 1 + length[j];
                        count[i] = count[j];
                    } else if (1 + length[j] == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        
        int max = 0;
        for (int i : length) max = Math.max(i,max);
        
        int ans = 0;
        for (int i = 0; i < n; i++){
            if (length[i] == max) {
                ans += count[i];
            }
        }
        
        return ans;
    }
}