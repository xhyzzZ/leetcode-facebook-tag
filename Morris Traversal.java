// Morris Traversal 

/*
二叉树遍历 O(1)空间复杂度
线索二叉树 threaded binary tree
*/

public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left == null) {
				list.add(cur.val);
				cur = cur.right;
			} else {
				TreeNode prev = cur.left;
				while (prev.right != null && prev.right != cur) { 
					prev = prev.right;
				}
				if (prev.right == null) {
					prev.right = cur;
					// Uncomment for pre-order
					// list.add(cur.val);
					cur = cur.left;
				} else {
					prev.right = null;
					// Uncomment for in-order
					// list.add(cur.val);
					cur = cur.right;
				}
			}
		}
		return list;
	}
}