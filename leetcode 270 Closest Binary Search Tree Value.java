//leetcode 270 Closest Binary Search Tree Value

/*
time: O(logn)
space: O()
*/

public class Solution {
    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        TreeNode kid = target < a ? root.left : root.right;
        if (kid == null) return a;
        int b = closestValue(kid, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }
}

public class Solution {
	public int closestValue(TreeNode root, double target) {
	    int res = root.val;   
	    while (root != null) {
	        if (Math.abs(target - root.val) < Math.abs(target - res)) {
	            res = root.val;
	        }      
	        root = root.val > target ? root.left : root.right;
	    }     
	    return res;
	}
}