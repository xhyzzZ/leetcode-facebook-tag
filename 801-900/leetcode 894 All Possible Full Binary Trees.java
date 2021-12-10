// leetcode 894 All Possible Full Binary Trees

/*
time: O(2^n)
space: O(2^n)
*/

class Solution {
    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (!memo.containsKey(n)) {
            List<TreeNode> ans = new LinkedList();
            if (n == 1) {
                ans.add(new TreeNode(0));
            } else if (n % 2 == 1) {
                for (int x = 0; x < n; ++x) {
                    int y = n - 1 - x;
                    for (TreeNode left : allPossibleFBT(x))
                        for (TreeNode right: allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                }
            }
            memo.put(n, ans);
        }

        return memo.get(n);
    }
}