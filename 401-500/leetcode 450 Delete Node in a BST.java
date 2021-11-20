//leetcode 450 Delete Node in a BST

/*
time: O(logn)
space: O(h)
*/

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

	    if (key < root.val) {
	        root.left = deleteNode(root.left, key);
	    } else if (key > root.val) {
	        root.right = deleteNode(root.right, key);
	    } else {
	    	if (root.left == null && root.right == null) root = null;
      		else if (root.right != null) {
      			// the node is not a leaf and has a right child
        		root.val = successor(root);
       			root.right = deleteNode(root.right, root.val);
      		} else {
      			// the node is not a leaf, has no right child, and has a left child  
        		root.val = predecessor(root);
        		root.left = deleteNode(root.left, root.val);
      		}
	    }
	    return root;
	}

	private int successor(TreeNode root) {
		/*
		One step right and then always left
		*/
		root = root.right;
		while (root.left != null) root = root.left;
		return root.val;
	}

    private int predecessor(TreeNode root) {
    	/*
		One step left and then always right
		*/
	    root = root.left;
	    while (root.right != null) root = root.right;
	    return root.val;
	}
}