// leetcode 662 Maximum Width of Binary Tree

/*
time: O(n)
space: O(h)
*/

dfs
class Solution {
    private int max = 1;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        List<Integer> startOfLevel = new ArrayList<>();
        helper(root, 0, 1, startOfLevel);
        return max;
    }
    public void helper(TreeNode root, int level, int index, List<Integer> list) {
        if (root == null) return;
        if (level == list.size()) list.add(index);
        max = Math.max(max, index + 1 - list.get(level));
        helper(root.left, level + 1, index * 2, list);
        helper(root.right, level + 1, index * 2 + 1, list);
    }
}

/*
time: O(n)
space: O(h)
*/

bfs
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        root.val = 0;
        int max = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            max = Math.max(max, queue.peekLast().val - queue.peekFirst().val + 1);
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.left != null) {
                    root.left.val = root.val * 2;
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    root.right.val = root.val * 2 + 1;
                    queue.offer(root.right);
                }
            }
        }
        return max;
    }
}