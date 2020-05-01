//leetcode 101 Symmetric Tree


/*
time: O(n)
space: O(h)
*/

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode p, TreeNode q) {
    	if (p == null || q == null) return false;
    	if (p == null && q == null) return true;
    	return (p.val == q.val) && helper(p.left, q.right) & helper(p.right, q.left);
    }
}