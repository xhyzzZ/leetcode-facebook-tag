// leetcode 334 Increasing Triplet Subsequence

/*
time: O(n)
space: O(1)
*/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) {
                // update small if n is smaller than both
                small = n; 
            } else if (n <= big) {
                // update big only if greater than small but smaller than big
                big = n;
            } 
            else return true; // return if you find a number bigger than both
        }
        return false;
    }
}