//leetcode 663 Equal Tree Partition

/*
time: O(n)
space: O()

first round, postorder traverse. Using the node itself to store the total sum of its subtree.
second round, preorder traverse. Check every possible partition.
*/

class Solution {
    public boolean checkEqualTree(TreeNode root) {
        if (root == null) return false;
        int sum = getSum(root);
        if (sum % 2 != 0) return false;

        return checkMatch(root, sum, sum / 2);
    }

    private boolean checkMatch(TreeNode root, int sum, int target) {
    	if (root == null) return false;
    	if (root.left != null && sum - root.left.val == target) return true;
    	if (root.right != null && sum - root.right.val == target) return true;

    	return checkMatch(root.left, sum, target) || checkMatch(root.right, sum, target);
    }

    private int getSum(TreeNode root) {
    	if (root == null) return 0;
    	root.val = root.val + getSum(root.left) + getSum(root.right);
    	return root.val;
    }
}