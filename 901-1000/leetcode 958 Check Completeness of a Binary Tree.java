// leetcode 958 Check Completeness of a Binary Tree

/*
time: O(n)
space: O(h)
*/

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        while (!queue.isEmpty() && queue.peek() == null) queue.poll();
        return queue.isEmpty();
    }
}