//leetcode 99 Recover Binary Search Tree

/*
time: O(n)
space: O(n)
*/
public class Solution {

	TreeNode first = null;
	TreeNode second = null;
	TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        if(root == null) return;
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void helper(TreeNode root) {
    	if(root == null) return;
    	helper(root.left);
    	if(prev != null && prev.val >= root.val) {
    		if(first == null) first = prev;
    		second = root;
    	}
    	prev = root;
    	helper(root.right);
    }
}