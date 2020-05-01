//leetcode 191 Number of 1 Bits

/*
time: O()
space: O()
*/

public class Solution {
    public static int hammingWeight(int n) {
	int ones = 0;
    	while(n != 0) {
    		ones = ones + (n & 1);
    		n = n >>> 1;
    	}
    	return ones;
	}
}