// leetcode 1120 Maximum Average Subtree

/*
time: O(n)
space: O(n)
*/

class Solution {
    double maxAverage = Double.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return maxAverage;
    }
    
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int[] ans = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        ans[0] = left[0] + right[0] + root.val;
        ans[1] = left[1] + right[1] + 1;
        maxAverage = Math.max(maxAverage, (double) ans[0] / (double) ans[1]);
        return ans;
    }
}