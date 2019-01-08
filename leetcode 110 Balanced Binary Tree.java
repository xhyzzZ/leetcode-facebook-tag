//leetcode 110 Balanced Binary Tree


/*
time: O(n)
space: O(1)
*/
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    public int helper(TreeNode root) {
    	if(root == null) return 0;

    	int left = helper(root.left);
    	if(left != -1) {
    		int right = helper(root.right);
    		if(right != -1) {
    			return Math.abs(left - right) <= 1 ? 1 + Math.max(left, right) : -1;
    		}
    	}
    	return -1;
    }
}