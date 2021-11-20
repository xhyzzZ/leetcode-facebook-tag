//leetcode 298 Binary Tree Longest Consecutive Sequence

/*
time: O(n)
space: O(h)
*/

class Solution {
    public int longestConsecutive(TreeNode root) {
	    return dfs(root, null, 0);
	}

	private int dfs(TreeNode p, TreeNode parent, int length) {
	    if (p == null) return length;
	    length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
	    return Math.max(length, Math.max(dfs(p.left, p, length), dfs(p.right, p, length)));
	}
}