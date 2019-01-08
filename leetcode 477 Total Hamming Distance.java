//leetcode 477 Total Hamming Distance

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int totalHammingDistance(int[] nums) {
        int count = 0, k = 0, mask = 1;
        for(int i = 0; i < 32; i++) {
            k = 0;
            for(int n : nums)
                if( (n & mask) != 0) ++k;
            mask <<= 1;
            count += k * (nums.length - k);
        }
        return count;
    }
}