//leetcode 102 Binary Tree Level Order Traversal


/*
time: O()
space: O()
*/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if (root == null) return wrapList;
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}

/*
time: O(n)
space: O(n)
*/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<>();
    	helper(res, root, 0);
    	return res;
    }

    public void helper(List<List<Integer>> res, TreeNode root, int height) {
    	if (root == null) return;
    	if (height >= res.size()) {
    		res.add(new ArrayList<Integer>());
    	}
    	res.get(height).add(root.val);
    	helper(res, root.left, height + 1);
    	height(res, root.right, height + 1);
    }
}