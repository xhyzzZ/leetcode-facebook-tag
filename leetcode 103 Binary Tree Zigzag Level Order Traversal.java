//leetcode 103 Binary Tree Zigzag Level Order Traversal


/*
time: O(n)
space: O(n)
*/
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, 0, root);
        return res;
    }

    private void helper(List<List<Integer>> res, int level, TreeNode cur) {
    	if(cur == null) return;
    	if(res.size() <= level) {
    		res.add(new ArrayList<>());
    	}
    	if(level % 2 == 0) {
    		res.get(level).add(cur.val);
    	} else {
    		res.get(level).add(0, cur.val);
    	}
    	helper(res, level + 1, cur.left);
    	helper(res, level + 1, cur.right);
    }
}