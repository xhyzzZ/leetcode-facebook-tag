//leetcode 1026 Maximum Difference Between Node and Ancestor

/*
time: O(n)
space: O()
*/

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val); // initialize both max and min with root.val.
    }
    private int dfs(TreeNode n, int max, int min) {
        if (n == null) return 0;    // base case.
        max = Math.max(n.val, max); // update max.
        min = Math.min(n.val, min); // update min.
        int l = dfs(n.left, max, min); // recurse down.
        int r = dfs(n.right, max, min); // recurse down.
        return Math.max(max - min, Math.max(l, r)); // compare all super/sub differences to get result.
    }
}