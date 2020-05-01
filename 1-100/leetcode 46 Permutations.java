//leetcode 46 Permutations


/*
time: O(n!) O(2^n * n)
space: O(n)
Permutations: [1,2,3] tempList of backtracking solution displayed here:
Before removal: 1
Before removal: 1 2
Before removal: 1 2 3
After removal: 1 2
After removal: 1
Before removal: 1 3
Before removal: 1 3 2
After removal: 1 3
After removal: 1
After removal:
Before removal: 2
Before removal: 2 1
Before removal: 2 1 3
After removal: 2 1
After removal: 2
Before removal: 2 3
Before removal: 2 3 1
After removal: 2 3
After removal: 2
After removal:
Before removal: 3
Before removal: 3 1
Before removal: 3 1 2
After removal: 3 1
After removal: 3
Before removal: 3 2
Before removal: 3 2 1
After removal: 3 2
After removal: 3
After removal:
*/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) return res;
        helper(res, new ArrayList<>(), nums);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
    	if (tempList.size() == nums.length) {
    		res.add(new ArrayList<>(tempList));
    		return;
    	}

    	for (int i = 0; i < nums.length; i++) {
    		if (tempList.contains(nums[i])) continue; //O(n)
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

    public static void helper(List<List<Integer>> res, List<Integer> tempList, Set<Integer> tempSet, int[] nums) {
        if (tempSet.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempSet.contains(nums[i])) continue; //O(1)
            tempSet.add(nums[i]);
            tempList.add(nums[i]);
            helper(res, tempList, tempSet, nums);
            tempSet.remove(tempList.get(tempList.size() - 1));
            tempList.remove(tempList.size() - 1);
        }
    }
}