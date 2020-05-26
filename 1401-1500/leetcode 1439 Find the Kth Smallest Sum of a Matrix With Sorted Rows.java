// leetcode 1439 Find the Kth Smallest Sum of a Matrix With Sorted Rows

/*
time: O(klogk len)
space: O(k)
*/

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for (int[] row : mat) {
            PriorityQueue<Integer> next = new PriorityQueue<>(Collections.reverseOrder());
            for (int prev : pq) {
                for (int cur : row) {
                    next.add(prev + cur);
                }   
            }
                
            while (next.size() > k) next.poll();
            pq = next;
        }
        return pq.poll();
    }
}