// leetcode 968 Binary Tree Cameras

/*
time: O(n)
space: O(h)
*/

class Solution {
    int camera = 0;
    public enum Camera { HAS_CAMERA, COVERED, PLEASE_COVER };
    
    public int minCameraCover(TreeNode root) {
        // If root is not covered then we need to place a camera at root node
        return cover(root) == Camera.PLEASE_COVER ? ++camera : camera;
    }
    
    public Camera cover(TreeNode root) {
        
        // Base case - if there is no node then it's already covered
        if (root == null) return Camera.COVERED;
        
        // Try to cover left and right children's subtree
        Camera l = cover(root.left);
        Camera r = cover(root.right);
        
        // If Any one of the children is not covered then we must place a camera at current node
        if (l == Camera.PLEASE_COVER || r == Camera.PLEASE_COVER) {
            camera++;
            return Camera.HAS_CAMERA;
        }
        
        // If any one of left or right node has Camera then the current node is also covered
        if (l== Camera.HAS_CAMERA || r == Camera.HAS_CAMERA) 
            return Camera.COVERED;
        
        // If None of the children is covering the current node then ask it's parent to cover
        return Camera.PLEASE_COVER;
    }
}