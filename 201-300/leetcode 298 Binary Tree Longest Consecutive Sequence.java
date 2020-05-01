//leetcode 298 Binary Tree Longest Consecutive Sequence

/*
time: O(n)
space: O(h)
*/

class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
			return 0;
		}
    	return dfs(root, root.val + 1, 1, 1);
	}

	private int dfs(TreeNode node, int target, int curr, int max) {
		if (node == null) {
			return max;
		}
		if (node.val == target) {
			curr++;
			max = Math.max(max, curr);
		} else {
			curr = 1;
		}
		return Math.max(dfs(node.left, node.val + 1, curr, max), 
						dfs(node.right, node.val + 1, curr, max));
    }
}