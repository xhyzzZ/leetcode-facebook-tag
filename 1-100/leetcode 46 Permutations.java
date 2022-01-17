// leetcode 46 Permutations

/*
time: O(n! * n)
space: O(n! * n) 
we did not take into account the space needed to hold the results. 
Otherwise, the space complexity would become O(n)
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) return res;
        helper(res, new ArrayList<>(), nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
    	if (tempList.size() == nums.length) {
    		res.add(new ArrayList<>(tempList));
    		return;
    	}

    	for (int i = 0; i < nums.length; i++) {
    		if (tempList.contains(nums[i])) continue; // O(n)
    		tempList.add(nums[i]);
    		helper(res, tempList, nums);
    		tempList.remove(tempList.size() - 1);
    	}
    }
}


public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) return res;
        helper(res, new ArrayList<>(), new HashSet<>(), nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> tempList, Set<Integer> tempSet, int[] nums) {
        if (tempSet.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempSet.contains(nums[i])) continue; // O(1)
            tempSet.add(nums[i]);
            tempList.add(nums[i]);
            helper(res, tempList, tempSet, nums);
            tempSet.remove(tempList.get(tempList.size() - 1));
            tempList.remove(tempList.size() - 1);
        }
    }
}