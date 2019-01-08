//leetcode 129 Sum Root to Leaf Numbers 

/*
time: O()
space: O()
*/
public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return sumR(root, 0);
    }

    public int sumR(TreeNode root, int x) {
    	if(root.right == null && root.left == null) return 10 * x + root.val;
    	int val = 0;
    	if(root.left != null) {
    		val += sumR(root.left, 10 * x + root.val);
    	}
    	if(root.right != null) {
    		val += sumR(root.right, 10 * x + root.val);
    	}
    	return val;
    }
}