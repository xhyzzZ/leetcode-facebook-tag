// leetcode 1123 Lowest Common Ancestor of Deepest Leaves

/*
time: O(n)
space: O(h)
*/

class Solution {
    int max = 0;
  	TreeNode lca;
 
	public TreeNode lcaDeepestLeaves(TreeNode root) {
    	lca = root;
     
    	helper(root, 0);
    	return lca;
	}


 	private int helper(TreeNode node, int depth) {
    	if (node == null) return 0;
     
     	// deepest leaves 有可能是一个/多个，如果是一个那么result就是他自己，所以这里就先将lca设置成最深的node
     	if (depth > max) {
         	max = depth;
         	lca = node;
     	}
     
     	// recurse function, 先到最left， 再到最right，同时把lca和max更新成最下面的值(见上面代码)， 
     	// 然后从下面往上走，如果遇见一个node左右高度相等（见下面代码），就把lca设置成node。
     	int maxLeft = helper(node.left, depth + 1);
     	int maxRight = helper(node.right, depth + 1);
     
     	// deepest leaf 有可能是一个/多个，如果是一个那么result就是他自己，
     	// 如果是多个（好几个节点的深度一样，都是最深）就说明他们的height是一样的，那么从下往上，
     	// 找到的第一个左右子树height一样的node就是lca
     	if (max == maxLeft && max == maxRight) lca = node; 
     
     	// return的是左右子树高度的最大值
     	return Math.max(depth, Math.max(maxLeft, maxRight));
 	}
}