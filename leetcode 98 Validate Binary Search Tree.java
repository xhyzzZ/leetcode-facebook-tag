//leetcode 98 Validate Binary Search Tree


/*
time: O(n)
space: O(h)
*/

dfs
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, null, null);
    }

    public static boolean helper(TreeNode root, Integer min, Integer max) {
    	if (root == null) return true;
    	if (min != null && root.val <= min) return false;
    	if (max != null && root.val >= max) return false;
    	return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}

bfs
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
               stack.push(root);
               root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}