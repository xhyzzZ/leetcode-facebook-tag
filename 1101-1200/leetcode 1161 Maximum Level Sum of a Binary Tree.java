// leetcode 1161 Maximum Level Sum of a Binary Tree

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0, max = Integer.MIN_VALUE, res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(), sum = 0;
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (sum > max) {
                max = sum;
                res = level;
            }
        }
        return res;
    }
}