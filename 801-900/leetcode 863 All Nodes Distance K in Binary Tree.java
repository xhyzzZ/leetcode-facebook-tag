// leetcode 863 All Nodes Distance K in Binary Tree

/*
time: O(n)
space: O(n)
*/

class Solution {
    Map<TreeNode, List<TreeNode>> map = new HashMap();
    // here can also use Map<TreeNode, TreeNode> to only store the child - parent mapping, 
    // since parent-child mapping is inherent in the tree structure
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null || k < 0) return res;
        buildMap(root, null); 
        if (!map.containsKey(target)) return res;
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (k == 0) {
                for (int i = 0; i < size; i++) res.add(queue.poll().val);
                return res;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                for (TreeNode next : map.get(node)) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    queue.add(next);
                }
            }
            k--;
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