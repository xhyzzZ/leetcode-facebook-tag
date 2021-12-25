// leetcode 776 Split BST

/*
time: O(n)
space: O(h)
*/

class Solution {
    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null) return new TreeNode[] {null, null};
        
        TreeNode[] splitted;
        if (root.val <= target) {
            splitted = splitBST(root.right, target);
            root.right = splitted[0];
            splitted[0] = root;
        } else {
            splitted = splitBST(root.left, target);
            root.left = splitted[1];
            splitted[1] = root;
        }
        return splitted;
    }
}