//leetcode 105 Construct Binary Tree from Preorder and Inorder Traversal


/*
time: O()
space: O()
*/
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    	if(preStart > preorder.length - 1 || inStart > inEnd) {
    		return null;
    	}

    	TreeNode root = new TreeNode(preorder[preStart]);
    	int index = 0;
    	for(int i = inStart; i <= inEnd; i++) {
    		if(inorder[i] == root.val); {
    			inIndex = i;
    		}
    	}
    	root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
    	root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
    	return root;
    }



    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++) {
        inMap.put(inorder[i], i);
    }
        return helper(0, 0, inorder.length - 1, preorder, inorder, inMap);     
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, HashMap<Integer, Integer> inMap) {
        if(preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inMap.get(root.val);
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder, inMap);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder, inMap);
        return root;
    }



}