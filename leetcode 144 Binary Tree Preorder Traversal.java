//leetcode 144 Binary Tree Preorder Traversal


/*
time: O(n)
space: O()
*/
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        helper(root, pre);
        return pre;
    }

    public void helper(TreeNode root, List<Integer> pre) {
    	if(root == null) return;
    	pre.add(root.val);
    	helper(root.left, pre);
    	helper(root.right, pre);
    }

    //stack interative

    public List<Integer> preorderTraversal(TreeNode node) {
		List<Integer> pre = new LinkedList<Integer>();
		if(root == null) return pre;
		Stack<TreeNode> tovisit = new Stack<TreeNode>();
		tovisit.push(root);
		while(!tovisit.empty()) {
			TreeNode visiting = tovisit.pop();
			pre.add(visiting.val);
			if(visiting.right != null) tovisit.push(visiting.right);
			if(visiting.left != null) tovisit.push(visiting.left);
		}
		return pre;
	}
}