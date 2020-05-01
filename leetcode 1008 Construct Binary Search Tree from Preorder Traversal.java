//leetcode 1008 Construct Binary Search Tree from Preorder Traversal

/*
time: O(n)
space: O(n)
*/

class Solution {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) return null;
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = bstFromPreorder(preorder, root.val);
        root.right = bstFromPreorder(preorder, bound);
        return root;
    }
}