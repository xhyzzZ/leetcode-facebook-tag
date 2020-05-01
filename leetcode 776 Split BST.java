//leetcode 776 Split BST

/*
time: O(logn)
space: O()
*/

class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if(root == null) return new TreeNode[] {null, null};
        
        TreeNode[] splitted;
        if(root.val <= V) {
            splitted = splitBST(root.right, V);
            root.right = splitted[0];
            splitted[0] = root;
        } else {
            splitted = splitBST(root.left, V);
            root.left = splitted[1];
            splitted[1] = root;
        }
        return splitted;
    }
}