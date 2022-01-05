// leetcode 1937 Maximum Number of Points with Cost

/*
time: O(n^2)
space: O(n)
*/

class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] pre = new long[n];
        for (int i = 0; i < n; i++) pre[i] = points[0][i];
        for (int i = 0; i < m - 1; i++) {
            long[] left = new long[n], right = new long[n], cur = new long[n];
            left[0] = pre[0];
            right[n - 1] = pre[n - 1];
            for (int j = 1; j < n; j++) left[j] = Math.max(left[j - 1] - 1, pre[j]);
            for (int j = n - 2; j >= 0; j--) right[j] = Math.max(right[j + 1] - 1, pre[j]);
            for (int j = 0; j < n; j++) cur[j] = points[i + 1][j] + Math.max(left[j], right[j]);
            pre = cur;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) ans = Math.max(ans, pre[i]);
        return ans;
    }
}

