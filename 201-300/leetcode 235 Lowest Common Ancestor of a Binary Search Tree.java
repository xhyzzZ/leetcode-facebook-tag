//leetcode 235 Lowest Common Ancestor of a Binary Search Tree

/*
time: O(n)
space: O(h)
*/
bfs
public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    while ((root.val - p.val) * (root.val - q.val) > 0) {
        	root = p.val < root.val ? root.left : root.right;
	    }
    	return root;
	}
}

dfs
public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	return (root.val - p.val) * (root.val - q.val) < 1 ? root :
           lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
	}
}
