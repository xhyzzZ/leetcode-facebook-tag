//leetcode 102 Binary Tree Level Order Traversal


/*
time: O(n)
space: O(h)
*/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> levels = new LinkedList<List<Integer>>();
        
        if (root == null) return levels;
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            levels.add(new ArrayList<Integer>());
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return levels;
    }
}

/*
time: O(n)
space: O(h)
*/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<>();
    	helper(res, root, 0);
    	return res;
    }

    public void helper(List<List<Integer>> res, TreeNode root, int height) {
    	if (root == null) return;
        // start the current level
        if (res.size() == height) res.add(new ArrayList<Integer>());
    	res.get(height).add(root.val);
    	helper(res, root.left, height + 1);
    	helper(res, root.right, height + 1);
    }
}