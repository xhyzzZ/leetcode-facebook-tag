// leetcode 993 Cousins in Binary Tree

/*
time: O(n)
space: O(h)
*/

dfs
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue <TreeNode> queue = new LinkedList <> ();
        queue.add(root);

        while (!queue.isEmpty()) {
            boolean siblings = false;
            boolean cousins = false;

            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.remove();

                // Encountered the marker.
                // Siblings should be set to false as we are crossing the boundary.
                if (node == null) {
                    siblings = false;
                } else {
                    if (node.val == x || node.val == y) {
                        // Set both the siblings and cousins flag to true
                        // for a potential first sibling/cousin found.
                        if (!cousins) {
                            siblings = cousins = true;
                        } else {
                            // If the siblings flag is still true this means we are still
                            // within the siblings boundary and hence the nodes are not cousins.
                            return !siblings;
                        }
                    }

                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    // Adding the null marker for the siblings
                    queue.add(null);
                }
            }
            // After the end of a level if `cousins` is set to true
            // This means we found only one node at this level
            if (cousins) return false;
        }
        return false;
    }
}

/*
time: O(n)
space: O(h)
*/

dfs
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        return findDepth(root, x, 1) == findDepth(root, y, 1) && !isSibling(root, x, y); 
    }
    
    private boolean isSibling(TreeNode node, int x, int y) {
        if (node == null) return false;
        
        boolean check = false;
        if (node.left != null && node.right != null){
            check = (node.left.val == x && node.right.val == y) ||
                    (node.left.val == y && node.right.val == x);
        }
        return check || isSibling(node.left, x, y) || isSibling(node.right, x, y);
    }
    
    private int findDepth(TreeNode node, int val, int height) {
        if (node == null) return 0;
        if (node.val == val) return height;
        
        return findDepth(node.left, val, height + 1) | findDepth(node.right, val, height + 1);
    }
}