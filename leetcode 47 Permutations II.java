//leetcode 47 Permutations II


/*
time: O(n!)
space: O(n)

*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
    	if (list.size() == nums.length) {
    		res.add(new ArrayList<>(list));
    	}
    	for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
    		if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
    		used[i] = true;
    		list.add(nums[i]);
    		helper(res, list, nums, used);
    		used[i] = false;
    		list.remove(list.size() - 1);
    	}
    }
}