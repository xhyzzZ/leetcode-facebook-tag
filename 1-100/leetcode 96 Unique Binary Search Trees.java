//leetcode 96 Unique Binary Search Trees

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int numTrees(int n) {
        // Note: we should use long here instead of int, otherwise overflow
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}