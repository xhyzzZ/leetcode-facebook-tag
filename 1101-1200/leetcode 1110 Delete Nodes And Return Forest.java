// leetcode 1110 Delete Nodes And Return Forest

/*
time: O(to_delete.length + n)
space: O(to_delete.length + h)
*/

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) set.add(i);
        List<TreeNode> res = new ArrayList<>();
        if (!set.contains(root.val)) res.add(root);
        dfs(root, set, res);
        return res;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> set, List<TreeNode> res) {
        if (node == null) return null;
        node.left = dfs(node.left, set, res);
        node.right = dfs(node.right, set, res);
        if (set.contains(node.val)) {
            if (node.left != null) res.add(node.left);
            if (node.right != null) res.add(node.right);
            return null;
        }
        return node;
    }
}