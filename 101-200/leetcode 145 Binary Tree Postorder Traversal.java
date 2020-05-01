// leetcode 145 Binary Tree Postorder Traversal

/*
time: O(n)
space: O(h)
*/

class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(0, cur.val);
            if (cur.left != null) {
            	stack.push(cur.left);
            }
            if (cur.right != null) {
               stack.push(cur.right); 
            }
        }
        return res;
    }
}
