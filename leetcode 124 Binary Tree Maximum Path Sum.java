//leetcode 124 Binary Tree Maximum Path Sum

/*
time: O(n)
space: O(h)
*/
public class Solution {
    // 全局变量，用于连接不连续的状态
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfsBottomUp(root);
        return max;
    }
    private int dfsBottomUp(TreeNode root) {
        if (root == null) return 0;
        // 检查两边的做大路径和，或者直接抛弃（取值为0）
        // 因此当一个小三角形一边为负数的时候
        // 最后返回的结果看起来是三个点的和，其实只是一条边
        int left = Math.max(0, dfsBottomUp(root.left));
        int right = Math.max(0, dfsBottomUp(root.right));
        // 检查通过当前 “root” 的三角形路线（拐弯）
        // 不需要单独再取 Left / Right 中的最大值
        // 因为在 Bottom-Up 的递归中左右子树的最大路径已经被更新过了
        // 即其中某个分支为负时，最大子树和 = 最大路径和
        max = Math.max(max, left + right + root.val);
        // 传递到上一层的路线必须连续且不能拐弯，保持连续的递归状态
        return Math.max(left, right) + root.val;
    }
}