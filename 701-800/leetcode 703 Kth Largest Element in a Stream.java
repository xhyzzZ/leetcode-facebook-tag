// leetcode 703 Kth Largest Element in a Stream

/*
time: add() is O(log k)
the constructor KthLargest() is O(n log k)
space: O(k)
*/

class KthLargest {

    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private final int k;    

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (Integer i : nums) {
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }        
        return minHeap.peek();
    }
}