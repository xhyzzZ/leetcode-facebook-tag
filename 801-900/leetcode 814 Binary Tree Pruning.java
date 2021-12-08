// leetcode 814 Binary Tree Pruning

/*
time: O(n)
space: O(h)
*/

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return (root.val == 1 || root.left != null || root.right != null) ? root : null;
    }
}