// leetcode 268 Missing Number

/*
time: O(n)
space: O(1)
*/

public class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}

		return xor ^ i;
    }
}

public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += i;
            sum -= nums[i];
        }
        sum += nums.length;
        return sum;
    }
}