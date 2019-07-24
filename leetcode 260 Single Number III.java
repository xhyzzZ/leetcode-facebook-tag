//leetcode 260 Single Number III

/*
time: O(n)
space: O(1)
*/

public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
        	diff ^= num;
        }
        diff &= -diff;

        int[] rets = new int[2];
        for (int num : nums) {
        	if ((num & diff) == 0) {
        		rets[0] ^= num;
        	} else {
        		rets[1] ^= num;
        	}
        }
        return rets;
    }
}