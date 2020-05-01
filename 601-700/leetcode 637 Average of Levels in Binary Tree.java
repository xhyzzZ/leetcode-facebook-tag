//leetcode 637 Average of Levels in Binary Tree


/*
time: O(n)
space: O(h)
*/

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
	    Queue<TreeNode> queue = new LinkedList<>();
	    
	    if (root == null) return result;
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        int n = queue.size();
	        double sum = 0.0;
	        for (int i = 0; i < n; i++) {
	            TreeNode node = queue.poll();
	            sum += node.val;
	            if (node.left != null) queue.offer(node.left);
	            if (node.right != null) queue.offer(node.right);
	        }
	        result.add(sum / n);
	    }
	    return result;
    }
}
