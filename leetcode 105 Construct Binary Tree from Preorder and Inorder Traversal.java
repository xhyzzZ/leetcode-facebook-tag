//leetcode 105 Construct Binary Tree from Preorder and Inorder Traversal


/*
time: O(n)
space: O(h)
*/
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preorder, int[] inorder, int preorderIndex, 
        int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd || preorderIndex >= preorder.length) return null;
        int rootVal = preorder[preorderIndex];
        int pos = inorderStart;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootVal) {
                pos = i;
                break;
            }
        }
        int leftSubTreeLength = pos - inorderStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, inorder, preorderIndex + 1, inorderStart, pos - 1);
        root.right = build(preorder, inorder, preorderIndex + leftSubTreeLength + 1, pos + 1, inorderEnd);
        return root;
    }
}