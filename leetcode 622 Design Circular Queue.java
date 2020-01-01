//leetcode 622 Design Circular Queue

/*
time: O()
space: O()
*/

class MyCircularQueue {

    int count = 0;
    int[] que ;
    int start = 0;
    int end = -1;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        que = new int[k];    
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        end = (end + 1) % que.length;
        que[end] = value;
        count++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        start = (start + 1) % que.length;
        count--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : que[start];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
          return isEmpty() ? -1 : que[end];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
         return count == que.length;
    }
}