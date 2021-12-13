// leetcode 896 Monotonic Array

/*
time: O(n)
space: O(1)
*/

two pass
class Solution {
    public boolean isMonotonic(int[] nums) {
        return increasing(nums) || decreasing(nums);
    }

    public boolean increasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return false;
        }
        return true;
    }

    public boolean decreasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i+1]) return false;
        }
        return true;
    }
}

/*
time: O(n)
space: O(1)
*/

one pass
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) increasing = false;
            if (nums[i] < nums[i + 1]) decreasing = false;
        }

        return increasing || decreasing;
    }
}