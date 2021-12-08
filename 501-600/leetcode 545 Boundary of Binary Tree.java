// leetcode 545 Boundary of Binary Tree

/*
time: O(n)
space: O(h)
*/

class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        if (root != null) {
        	ls.add(root.val);
        	lookupElmes(root.left, ls, true, false);
        	lookupElmes(root.right, ls, false, true);
        }
        return ls;
    }

    private void lookupElmes(TreeNode root, List<Integer> ls, boolean isLeftBoundary, boolean isRightBoundary) {
    	if (root == null) return;
    	if (root.left == null && root.right == null) {
    		ls.add(root.val);
    		return;
    	}
    	if (isLeftBoundary) {
    		ls.add(root.val);
    	}

    	lookupElmes(root.left, ls, root.left != null && isLeftBoundary, root.right == null && isRightBoundary);
    	lookupElmes(root.right, ls, root.left == null && isLeftBoundary, root.right != null && isRightBoundary);
    	if (isRightBoundary) {
    		ls.add(root.val);
    	}
    }
}


class Solution {
    List<Integer> nodes = new ArrayList<>(1000);
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
	    
	    if (root == null) return nodes;

	    nodes.add(root.val);
	    leftBoundary(root.left);
	    leaves(root.left);
	    leaves(root.right);
	    rightBoundary(root.right);
	    
	    return nodes;
	}

	public void leftBoundary(TreeNode root) {
	    if (root == null || (root.left == null && root.right == null)) return;
	    nodes.add(root.val);
	    if (root.left == null) leftBoundary(root.right);
	    else leftBoundary(root.left);
	}

	public void rightBoundary(TreeNode root) {
	    if (root == null || (root.right == null && root.left == null)) return;
	    if (root.right == null) rightBoundary(root.left);
	    else rightBoundary(root.right);
	    nodes.add(root.val); // add after child visit(reverse)
	}

	public void leaves(TreeNode root) {
	    if (root == null) return;
	    if (root.left == null && root.right == null) {
	        nodes.add(root.val);
	        return;
	    }
	    leaves(root.left);
	    leaves(root.right);
	}
}

