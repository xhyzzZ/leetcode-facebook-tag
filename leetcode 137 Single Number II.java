//leetcode 137 Single Number II

/*
time: O()
space: O()
*/
public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
    	for(int i = 0; i < A.length; i++){
        	ones = (ones ^ A[i]) & ~twos;
        	twos = (twos ^ A[i]) & ~ones;
    	}
    	return ones;
    }
}