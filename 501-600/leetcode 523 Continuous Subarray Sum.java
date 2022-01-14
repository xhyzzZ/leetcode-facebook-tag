// leetcode 523 Continuous Subarray Sum

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

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        // -1 is just before you start the index. So if you get the first 2 elements sum to k, 
        // your current i is 1. So 1 - (-1) = 2 still satisfies the return True condition. 
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // Validate from the biggest possible n * k to k
            for (int j = (sum / k) * k; j >= k; j -= k) {
                if (map.containsKey(sum - j) && (i - map.get(sum - j) > 1)) return true;
            }
            if (!map.containsKey(sum)) map.put(sum, i);
        }

        return false;
    }
}