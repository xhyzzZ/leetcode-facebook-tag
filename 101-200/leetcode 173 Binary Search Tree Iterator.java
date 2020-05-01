//leetcode 173 Binary Search Tree Iterator

/*
time: O(n)
space: O(h)
*/

public class BSTIterator {

	private final Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
    	stack = new Stack<>();
    	TreeNode cur = root;
    	while (cur != null) {
    		stack.push(cur);
    		cur = cur.left;
    	}    
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode node = stack.pop();
        TreeNode cur = node.right;
        while (cur != null) {
        	stack.push(cur);
        	cur = cur.left;
        }
        return node.val;
    }
}
