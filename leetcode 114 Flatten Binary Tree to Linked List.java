//leetcode 114 Flatten Binary Tree to Linked List
    


/*
time: O(n)
space: O(h)h是高度
*/
public class Solution {
	private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.left);
        flatten(root.right);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}