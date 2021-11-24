// leetcode 410 Split Array Largest Sum

/*
time: O(n∗log(sumofarray))
space: O(1)
*/

class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        // binary search
        long start = max; 
        long end = sum;
        while (start < end) {
            long mid = start + (end - start) / 2;
            if (valid(mid, nums, m)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return (int) start;
    }

    public boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for (int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}