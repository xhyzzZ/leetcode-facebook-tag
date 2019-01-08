//leetcode 113 Path Sum II


/*
time: O()
space: O()
*/
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>, root, sum);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, TreeNode node, int sum) {
    	if(node == null) return;
    	list.add(node.val);

    	if(node.left == null && node.right == null) {
    		if(node.val == sum) {
    			res.add(new ArrayList<>(list));
    		}
    		list.remove(list.size() - 1);
    		return;
    	} else {
    		helper(res, list, node.left, sum - node.val);
    		helper(res, list, node.right, sum - node.val);
    		list.remove(list.size() - 1);
    	}
    }
}