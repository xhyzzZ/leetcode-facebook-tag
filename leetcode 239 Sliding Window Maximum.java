//leetcode 239 Sliding Window Maximum

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
		int[] res = new int[nums.length - k + 1];
		// Deque stores indexes of elements i, in descending order of nums[i]
		// First : smallet element in current window
		// Last : biggest element in current window
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && nums[i] > nums[deque.peekFirst()]) {
				deque.pollFirst();
			}	
			deque.offerFirst(i);
			// element to remove from sliding window
			if (i - k == deque.peekLast()) deque.pollLast();
			if (i - k + 1 >= 0) res[i - k + 1] = nums[deque.peekLast()];
		}
		return res;
    }
}