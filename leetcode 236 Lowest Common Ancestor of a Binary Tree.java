
//leetcode 236 Lowest Common Ancestor of a Binary Tree

/*
time: O(n)
space: O(h)
*/
dfs
public class Solution {
    // 抽象解释
    // 做一个二叉树的搜索
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 退出条件
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 都有值说明祖先为root
        if (left != null && right != null) return root;
        // 如果有一个有值，说明两个节点必定在同一边，所以返回先接触到的那个节点
        return left != null ? left : right;
    }
}

bfs
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}