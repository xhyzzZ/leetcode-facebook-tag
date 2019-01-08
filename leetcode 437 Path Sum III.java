//leetcode 437 Path Sum III

/*
time: O(n)
space: O()
*/

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }
    
    public int helper(TreeNode root, int curSum, int target, HashMap<Integer, Integer> preSum) {
    	if(root == null) return 0;

    	curSum += root.val;
    	int res = preSum.getOrDefault(curSum - target, 0);
    	preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);

    	res += helper(root.left, curSum, target, preSum) + helper(root.right, curSum, target, preSum);
    	preSum.put(curSum, preSum.get(curSum) - 1);
    	return res;
    }
}