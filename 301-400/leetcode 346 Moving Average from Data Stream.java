// leetcode 346 Moving Average from Data Stream

/*
time: O(1)
space: O(n)
*/

class MovingAverage {
    private int size, windowSum = 0, count = 0;
    private Deque<Integer> queue;

    public MovingAverage(int size) {
        this.size = size;
        this.queue = new ArrayDeque<Integer>();
    }

    public double next(int val) {
        count++;
        // calculate the new sum by shifting the window
        queue.add(val);
        int tail = count > size ? (int) queue.poll() : 0;

        windowSum = windowSum - tail + val;

        return windowSum * 1.0 / Math.min(size, count);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */