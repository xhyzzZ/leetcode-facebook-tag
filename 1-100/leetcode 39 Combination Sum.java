//leetcode 39 Combination Sum



/*
time: O(2^n)
space: O(n)
*/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
    	if (target < 0) return;
    	if (target == 0) {
    		res.add(new ArrayList<>(list));
    		return;
    	}
    	for (int i = start; i < candidates.length; i++) {
    		list.add(candidates[i])
    		helper(res, list, candidates, target - candidates[i], i);
    		list.remove(list.size() - 1);
    	}
    }
}