//leetcode 863 All Nodes Distance K in Binary Tree

/*
time: O(N^2)
space: O(N)
*/

class Solution {
    Map<TreeNode, List<TreeNode>> map = new HashMap();
    // here can also use Map<TreeNode, TreeNode> to only store the child - parent mapping, 
    // since parent-child mapping is inherent in the tree structure
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
         List<Integer> res = new ArrayList<Integer> ();
        if (root == null || K < 0) return res;
        buildMap(root, null); 
        if (!map.containsKey(target)) return res;
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(target);
        visited.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            if (K == 0) {
                for (int i = 0; i < size ; i++) res.add(q.poll().val);
                return res;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                for (TreeNode next : map.get(node)) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    q.add(next);
                }
            }
            K--;
        }
        return res;
    }
    
    private void buildMap(TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (!map.containsKey(node)) {
            map.put(node, new ArrayList<TreeNode>());
            if (parent != null) { 
            	map.get(node).add(parent); 
            	map.get(parent).add(node); 
            }
            buildMap(node.left, node);
            buildMap(node.right, node);
        }
    }    
}