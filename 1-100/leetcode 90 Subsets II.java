// leetcode 90 Subsets II

/*
time: O(2^n)
space: O(n)
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums== null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, 0);
        return;
    }
    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
    	res.add(new ArrayList<>(list));
    	for (int i = start; i < nums.length; i++) {
    		if (i > start && nums[i] == nums[i - 1]) continue;
    		list.add(num[i]);
    		helper(res, list, nums, i + 1);
    		list.remove(list.size() - 1);
    	}
    }
}