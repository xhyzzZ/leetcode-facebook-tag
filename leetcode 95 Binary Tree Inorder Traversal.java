//leetcode 95 Binary Tree Inorder Traversal

/*
time: O(n)
space: O(n)
*/

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()) {
        	while(cur != null) {
        		stack.add(cur);
        		cur = cur.left;
        	}
        	cur = stack.pop();
        	list.add(cur.val);
        	cur = cur.right;
        }
        return list;
    }
}