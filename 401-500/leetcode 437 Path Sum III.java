// leetcode 437 Path Sum III

/*
time: O(n)
space: O(h)
*/

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }
    
    public int helper(TreeNode root, int curSum, int target, HashMap<Integer, Integer> preSum) {
    	if (root == null) return 0;

        // update the prefix sum by adding the current val
    	curSum += root.val;
        // get the number of valid path, ended by the current node
    	int res = preSum.getOrDefault(curSum - target, 0);
        // update the map with the current sum, so the map is good to be passed to the next recursion
    	preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);

    	res += helper(root.left, curSum, target, preSum) + helper(root.right, curSum, target, preSum);
        // restore the map, as the recursion goes from the bottom to the top
    	preSum.put(curSum, preSum.get(curSum) - 1);
    	return res;
    }
}