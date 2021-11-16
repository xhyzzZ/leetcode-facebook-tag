//leetcode 865 Smallest Subtree with all the Deepest Nodes

/*
time: O(n)
space: O(h)
*/

// First Root to Leaf: return the deep level of every node
// Then Leaf to Root: only when the its left node and right node both have the deepthest level, update the result node
class Solution {
    int deepestLevel = 0;
    TreeNode res = null;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    
    private int dfs(TreeNode root, int level) {
        if (root == null) return level;
        
        int leftLevel = dfs(root.left, level + 1);
        int rightLevel = dfs(root.right, level + 1);
        
        int curLevel = Math.max(leftLevel, rightLevel);
        deepestLevel = Math.max(deepestLevel, curLevel);
        if (leftLevel == deepestLevel && rightLevel == deepestLevel)
            res = root;
        return curLevel;
    }
}