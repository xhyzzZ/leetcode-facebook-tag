// leetcode 80 Remove Duplicates from Sorted Array II

/*
time: O(n)
space: O(1)
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i] = n;
                i++;
            }
        }
        return i;
    }
}