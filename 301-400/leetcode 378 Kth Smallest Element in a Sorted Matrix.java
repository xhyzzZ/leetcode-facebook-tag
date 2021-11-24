// leetcode 378 Kth Smallest Element in a Sorted Matrix

/*
X = min(K,N)
time: O(X + klogX)
space: O()
*/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, ans = -1; // For general, the matrix need not be a square
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int r = 0; r < Math.min(m, k); ++r)
            minHeap.offer(new int[]{matrix[r][0], r, 0});

        for (int i = 1; i <= k; ++i) {
            int[] top = minHeap.poll();
            int r = top[1], c = top[2];
            ans = top[0];
            if (c + 1 < n) minHeap.offer(new int[]{matrix[r][c + 1], r, c + 1});
        }
        return ans;
    }
}

/*
time: O(nlog(Max−Min))
space: O(1)
*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n - 1][n - 1];
        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = getLessEqual(matrix, mid);
            if (count < k) start = mid + 1;
            else end = mid;
        }
        return start;
    }
    
    private int getLessEqual(int[][] matrix, int mid) {
        int res = 0;
        int n = matrix.length, i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > mid) i--;
            else {
                res += i + 1;
                j++;
            }
        }
        return res;
    }
}