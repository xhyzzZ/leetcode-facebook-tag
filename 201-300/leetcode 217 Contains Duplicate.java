// leetcode 217 Contains Duplicate

/*
time: O(n)
space: O(n)
*/

public class Solution {
	public boolean containsDuplicate(int[] nums) {
		final Set<Integer> distinct = new HashSet<Integer>();
		for (int num : nums) {
			if (distinct.contains(num)) return true;
			distinct.add(num);
		}
		return false;
	}
}