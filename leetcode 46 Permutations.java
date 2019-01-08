//leetcode 46 Permutations


/*
time: O(n!) O(2^n * n)
space: O(n)

*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 || nums == null) return res;
        helper(res, new ArrayList<>(), nums);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
    	if(list.size() == nums.length) {
    		res.add(new ArrayList<>(list));
    		return;
    	}

    	for(int i = 0; i < nums.length; i++) {
    		if(list.contains(nums[i])) continue; //O(n)
    		list.add(nums[i]);
    		helper(res, list, nums);
    		list.remove(list.size() - 1);
    	}
    }
}