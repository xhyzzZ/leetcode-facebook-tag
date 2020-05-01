//leetcode 523 Continuous Subarray Sum


/*
time: O(n)
space: O(k)
*/
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Since the size of subarray is at least 2.
        if (nums.length <= 1) return false;
        // Two continuous "0" will form a subarray which has sum = 0. 0 * k == 0 will always be true.
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) return true;
        }

        // At this point, k can't be "0" any longer.
        if (k == 0) return false;
        // Let's only check positive k. Because if there is a n makes n * k = sum, it is always true -n * -k = sum.
        if (k < 0) k = -k;

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        int sum = 0;
        sumToIndex.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // Validate from the biggest possible n * k to k
            for (int j = (sum / k) * k; j >= k; j -= k) {
                if (sumToIndex.containsKey(sum - j) && (i - sumToIndex.get(sum - j) > 1)) return true;
            }
            if (!sumToIndex.containsKey(sum)) sumToIndex.put(sum, i);
        }

        return false;
    }
}