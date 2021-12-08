// leetcode 235 Lowest Common Ancestor of a Binary Search Tree

/*
time: O(n)
space: O(1)
*/

iterative
public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    while ((root.val - p.val) * (root.val - q.val) > 0) {
        	root = p.val < root.val ? root.left : root.right;
	    }
    	return root;
	}
}

/*
time: O(n)
space: O(h)
*/

dfs
public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	return (root.val - p.val) * (root.val - q.val) < 1 ? root :
           lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
	}
}
