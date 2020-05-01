//leetcode 100 Same Tree


/*
time: O(n)
space: O(n)
*/
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (q.val != p.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(q.right, p.right);
    }
}