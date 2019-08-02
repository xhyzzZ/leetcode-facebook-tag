//leetcode 285 Inorder Successor in BST


/*
time: O(n)
space: O(h)
*/

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) { 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        boolean reached = false;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if (reached) return node;
            if (node == p) reached = true;
            cur = node.right;
        }
        return null;
    }
}


public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        TreeNode succ = null;
        while (root != null) {
        	if (p.val < root.val) {
        		succ = root;
        		root = root.left;
        	} else {
        		root = root.right;
        	}
        }
        return succ;
    }
}