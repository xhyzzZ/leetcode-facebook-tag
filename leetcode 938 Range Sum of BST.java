//leetcode 938 Range Sum of BST

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0; // base case.
        if (root.val < L) return rangeSumBST(root.right, L, R); // left branch excluded.
        if (root.val > R) return rangeSumBST(root.left, L, R); // right branch excluded.
        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R); // count in both children.
    }
}