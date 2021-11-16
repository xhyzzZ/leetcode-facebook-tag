//leetcode 938 Range Sum of BST

/*
time: O(n)
space: O(h)
*/

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0; // base case.
        if (root.val < low) return rangeSumBST(root.right, low, high); // left branch excluded.
        if (root.val > high) return rangeSumBST(root.left, low, high); // right branch excluded.
        return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high); // count in both children.
    }
}