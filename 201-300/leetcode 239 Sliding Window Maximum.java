// leetcode 239 Sliding Window Maximum

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	int length = nums.length;
        if (nums == null || length == 0) return new int[0];
		int[] res = new int[length - k + 1];
		// Deque stores indexes of elements i, in ascending order of nums[i]
		// First : biggest element in current window
		// Last : smallest element in current window
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < length; i++) {
			// remove numbers out of range k
			while (!deque.isEmpty() && deque.peek() < i - k + 1) {
				deque.poll();
			}

			// remove smaller numbers in k range as they are useless
			while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
				deque.pollLast();
			}

			deque.offer(i);
			// if window has k elements add to results (first k-1 windows have < k elements because 
			// we start from empty window and add 1 element each iteration)
			if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peek()];
            }
		}
		return res;
    }
}