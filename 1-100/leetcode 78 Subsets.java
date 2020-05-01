//leetcode 78 Subsets


/*
time: O(2^n)
space: O(n)
*/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) return res;
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
    	res.add(new ArrayList<>(list));
    	for (int i = start; i < nums.length; i++) {
    		list.add(nums[i]);
    		helper(res, list, nums, i + 1);
    		list.remove(list.size() - 1);
    	}
    }
}