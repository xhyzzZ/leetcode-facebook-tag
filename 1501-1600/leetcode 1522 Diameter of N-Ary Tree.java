// leetcode 1522 Diameter of N-Ary Tree

/*
time: O(n)
space: O(1)
*/


class Solution {
    int max = 0;
    public int diameter(Node root) {
        getDiameter(root);
        return max;
    }

    private int getDiameter(Node node) {
        if (node == null) return 0;
        int maxOne = 0; // max from all children
        int maxTwo = 0; // second max from all children
        for (Node child : node.children) {
            int res = getDiameter(child);
            if (res > maxOne) {
                maxTwo = maxOne;
                maxOne = res;
            } else if (res > maxTwo) {
                maxTwo = res;
            }
        }
        max = Math.max(max, maxOne + maxTwo);
        return maxOne + 1;
    }
}