// leetcode 1008 Construct Binary Search Tree from Preorder Traversal

/*
time: O(n)
space: O(n)
*/

recursive
class Solution {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null) return null;
        return bstHelper(preorder, Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    private TreeNode bstHelper(int[] preorder, int start, int end) {
        if (index == preorder.length || preorder[index] < start || preorder[index] > end) return null;
        int val = preorder[index++];
        TreeNode node = new TreeNode(val);
        node.left = bstHelper(preorder, start, val);
        node.right = bstHelper(preorder, val, end);
        return node;   
    }   
}

/*
time: O(n)
space: O(n)
*/

iterative
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if (n == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        for (int i = 1; i < n; i++) {
            // take the last element of the stack as a parent
            // and create a child from the next preorder element
            TreeNode node = stack.peek();
            TreeNode child = new TreeNode(preorder[i]);
            // adjust the parent 
            while (!stack.isEmpty() && stack.peek().val < child.val)
                node = stack.pop();

            // follow BST logic to create a parent-child link
            if (node.val < child.val) node.right = child;
            else node.left = child;
            // add the child into stack
            stack.push(child);
        }
        return root;
    }
}