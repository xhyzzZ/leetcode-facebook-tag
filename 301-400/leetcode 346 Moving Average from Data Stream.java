//leetcode 346 Moving Average from Data Stream

/*
time: O(1)
space: O()
*/

public class MovingAverage {
	Queue<Integer> queue;
    int capacity;
    int currSum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        capacity = size;
        currSum = 0;
    }
    
    public double next(int val) {
        currSum += val;
        queue.offer(val);
        
        if (q.size() > capacity) {
            currSum -= queue.poll();
        }
       
        return currSum * 1.0 / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */