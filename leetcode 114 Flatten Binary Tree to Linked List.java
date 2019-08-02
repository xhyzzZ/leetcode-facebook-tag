//leetcode 114 Flatten Binary Tree to Linked List
    


/*
time: O(n)
space: O(h)h是高度
*/
public class Solution {
	public void flatten(TreeNode root) {
		if(root == null) return;
		flatten(root.left);
		flatten(root.right);
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = null;
		root.right = left;
		while (root.right != null) {
			root = root.right;
		}
		root.right = right;
	}
}

// morris traversal
// O(1)

public class Solution {
	public void flatten(TreeNode root) {
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left == null) {
				cur = cur.right;
			} else {
				TreeNode prev = cur.left;
				while (prev.right != null) {
					prev = prev.right;
				}
				prev.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
		}
	}
}