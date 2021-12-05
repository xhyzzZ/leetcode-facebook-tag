// leetcode 169 Majority Element

/*
time: O(n)
space: O(1)
*/

public class Solution {
	public int majorityElement(int[] num) {
		int major = num[0], count = 1;
		for (int i = 1; i < num.length; i++) {
			if (count == 0) {
				count++;
				major = num[i];
			} else if (major == num[i]) {
				count++;
			} else count--;
		}

		return major;
	}
} 