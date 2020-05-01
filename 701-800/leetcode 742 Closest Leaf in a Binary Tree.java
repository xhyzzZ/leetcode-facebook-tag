//leetcode 742 Closest Leaf in a Binary Tree

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> backMap = new HashMap<>();   // store all edges that trace node back to its parent
        Queue<TreeNode> queue = new LinkedList<>();          // the queue used in BFS
        Set<TreeNode> visited = new HashSet<>();             // store all visited nodes
        
        // DFS: search for node whoes val == k
        TreeNode kNode = DFS(root, k, backMap);
        queue.add(kNode);
        visited.add(kNode);
        
        // BFS: find the shortest path
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr.left == null && curr.right == null) {
                return curr.val;
            }
            if(curr.left != null && visited.add(curr.left)) {
                queue.add(curr.left);
            }
            if(curr.right != null && visited.add(curr.right)) {
                queue.add(curr.right);
            }
            if(backMap.containsKey(curr) && visited.add(backMap.get(curr))) {  // go alone the back edge
                queue.add(backMap.get(curr));
            }
        }
        return -1; // never hit
    }
    
    private TreeNode DFS(TreeNode root, int k, Map<TreeNode, TreeNode> backMap) {
        if(root.val == k) {
            return root;
        }
        if(root.left != null) {
            backMap.put(root.left, root);        // add back edge
            TreeNode left = DFS(root.left, k, backMap);
            if(left != null) return left;
        }
        if(root.right != null) {
            backMap.put(root.right, root);       // add back edge
            TreeNode right = DFS(root.right, k, backMap);
            if(right != null) return right;
        }
        return null;
    }
}