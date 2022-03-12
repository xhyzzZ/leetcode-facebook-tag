// leetcode 39 Combination Sum

/*
time: O(n^(t/m + 1)) 
n be the number of candidates, t be the target value, and m be the minimal value among the candidates.

the maximum possible height of the tree is the Target divided by the vale of the smallest Candidate 
i.e. the longest possible combination.

At each node, it takes a constant time to process, 
except the leaf nodes which could take a linear time to make a copy of combination
space: O(t/m)
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(res, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}