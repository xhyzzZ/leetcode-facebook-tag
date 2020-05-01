//leetcode 103 Binary Tree Zigzag Level Order Traversal


/*
time: O(n)
space: O(h)
*/
bfs
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zigzag = false;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                if (zigzag) {
                    level.add(0, node.val);
                } else {
                    level.add(node.val);
                }
                
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
            zigzag = !zigzag;
        }
        return res;
    }
}

dfs
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, 0, root);
        return res;
    }

    private void helper(List<List<Integer>> res, int level, TreeNode cur) {
    	if (cur == null) return;
    	if (res.size() <= level) {
    		res.add(new ArrayList<>());
    	}
    	if (level % 2 == 0) {
    		res.get(level).add(cur.val);
    	} else {
    		res.get(level).add(0, cur.val);
    	}
    	helper(res, level + 1, cur.left);
    	helper(res, level + 1, cur.right);
    }
}
