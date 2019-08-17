//leetcode 114 Flatten Binary Tree to Linked List
    


/*
time: O(n)
space: O(h)h是高度
*/
public class Solution {
	public void flatten(TreeNode root) {
    	helper(root, null);
	}	
	private TreeNode helper(TreeNode root, TreeNode pre) {
	    if (root == null) return pre;
	    pre = helper(root.right, pre);    
	    pre = helper(root.left, pre);
	    root.right = pre;
	    root.left = null;
	    pre = root;
	    return pre;
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