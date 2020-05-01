//leetcode 136 Single Number

/*
time: O(n)
space: O(1)
*/
public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}