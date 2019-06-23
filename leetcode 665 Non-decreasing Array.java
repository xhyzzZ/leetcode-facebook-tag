//leetcode 665 Non-decreasing Array

/*
time: O(n)
space: O(1)
*/

class Solution {
    public boolean checkPossibility(int[] nums) {
        int modified = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (modified++ > 0) return false;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) nums[i - 1] = nums[i]; // lower a[i - 1]
                else nums[i] = nums[i - 1]; // rise a[i]
            }
        }
        return true;
    }
}