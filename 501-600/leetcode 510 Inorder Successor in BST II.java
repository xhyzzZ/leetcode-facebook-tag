// leetcode 510 Inorder Successor in BST II

/*
time: O(h)
space: O(1)
*/

class Solution {
  	public Node inorderSuccessor(Node node) {
	    // the successor is somewhere lower in the right subtree
	    if (node.right != null) {
	    	node = node.right;
	    	while (node.left != null) node = node.left;
	      	return node;
	    }

	    // the successor is somewhere upper in the tree
	    while (node.parent != null && node == node.parent.right) node = node.parent;
	    return node.parent;
  	}
}