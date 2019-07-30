//leetcode 129 Sum Root to Leaf Numbers 

/*
time: O(n)
space: O(h)
*/


public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int curSum) {
    	if (root == null) return 0;
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) return curSum;
        return helper(root.left, curSum) + helper(root.right, curSum);
    }
}