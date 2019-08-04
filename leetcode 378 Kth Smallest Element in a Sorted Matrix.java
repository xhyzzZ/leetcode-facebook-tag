//leetcode 378 Kth Smallest Element in a Sorted Matrix

/*
time: O(nlogm)
space: O()
*/
class Node {
    int row;
    int col;

    Node(int row, int col) {
    this.row = row;
    this.col = col;
    }
}
class Solution {
    public static int findKthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);
        // put the 1st element of each row in the min heap we don't need to 
        // push more than 'k' elements in the heap
        for (int i = 0; i < matrix.length && i < k; i++) {
            minHeap.add(new Node(i, 0));
        }
        // take the smallest (top) element form the min heap, if the running count is equal to k return the number
        // if the row of the top element has more elements, add the next element to the heap
        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result = matrix[node.row][node.col];
            if (++numberCount == k) break;
            node.col++;
            if (matrix[0].length > node.col) {
                minHeap.add(node);
            }
        }
        return result;
    }
}

/*
time: O(nlogm)
space: O()
*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = getLessEqual(matrix, mid);
            if (count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
    
    private int getLessEqual(int[][] matrix, int val) {
        int res = 0;
        int n = matrix.length, i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > val) i--;
            else {
                res += i + 1;
                j++;
            }
        }
        return res;
    }
}