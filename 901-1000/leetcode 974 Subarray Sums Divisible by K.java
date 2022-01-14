// leetcode 974 Subarray Sums Divisible by K

/*
time: O(n)
space: O(k)
*/

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // consider the first subarray with a remainder that equals to zero.
        map.put(0, 1);
        int count = 0, sum = 0;
        for (int num : nums) {
            sum = (sum + num) % k;
            if (sum < 0) sum += k;  // Because -1 % 5 = -1, but we need the positive mod 4
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}