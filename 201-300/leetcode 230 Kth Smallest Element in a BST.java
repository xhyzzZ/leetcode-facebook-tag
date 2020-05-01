//leetcode 230 Kth Smallest Element in a BST

/*
time: O(n)
space: O(h)
*/

dfs
class Solution {
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    private void helper(TreeNode root) {
        if (root.left != null) helper(root.left);
        count--;
        if (count == 0) {
            number = root.val;
            return;
        }
        if (root.right != null) helper(root.right);
    }
}

bfs
class Solution {
    public int kthSmallest(TreeNode root, int k) {
      	Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if (--k == 0) return node.val;
            cur = node.right;
        }
        return root.val;    
    }
}