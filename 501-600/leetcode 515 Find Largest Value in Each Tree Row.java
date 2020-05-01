//leetcode 515 Find Largest Value in Each Tree Row

/*
time: O(n)
space: O(h)
*/
dfs
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int d) {
        if (root == null) return;
        if (d == res.size()) {
            res.add(root.val);
        } else {
            //or set value update value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d + 1);
        helper(root.right, res, d + 1);
    }
}

bfs
class Solution {
	public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            result.add(max);
            max = Integer.MIN_VALUE;
        }
        return result;
    }
}