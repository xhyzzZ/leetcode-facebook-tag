//leetcode 229 Majority Element II

/*
time: O(n)
space: O(1)
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
		if (nums == null || nums.length == 0) return list;
		int count1 = 0;
		int count2 = 0;
		int num1 = 0;
		int num2 = 1;
		// 1 and 2 should be initialized to be different numbers
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == num1) {
				count1++;
			} else if (nums[i] == num2) {
				count2++;
			} else if (count1 == 0) {
				num1 = nums[i];
				count1 = 1;
			} else if(count2 == 0) {
				num2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		int n = nums.length;
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == num1) count1++;
			else if (nums[i] == num2) count2++;
		}
		if (count1 > n / 3) list.add(num1);
		if (count2 > n / 3) list.add(num2);
		return list;
    }
}