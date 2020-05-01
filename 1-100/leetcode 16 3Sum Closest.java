//leetcode 16 3Sum Closest

//time: O(n^2)
//space: O(1)

public class Solution {
	public int threeSumCloset(int [] nums, int target) {
		int result = nums[0] + nums[1] + nums[nums.length - 1];
		Arrays.sort(nums);
		for (i = 0; i < nums.length - 2; i++) {
			int start = i + 1, end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum > target) {
					end--;
				} else {
					start++;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		return result;
	}
}