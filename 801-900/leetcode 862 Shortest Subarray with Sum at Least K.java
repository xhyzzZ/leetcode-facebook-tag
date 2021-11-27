// leetcode 862 Shortest Subarray with Sum at Least K

/*
time: O(n)
space: O(n)
*/

// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/204290/Monotonic-Queue-Summary
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int length = nums.length;
        long[] prefix = new long[length + 1];
        for (int i = 0; i < length; i++)
            prefix[i + 1] = prefix[i] + (long) nums[i];

        // Want smallest y-x with prefix[y] - prefix[x] >= k
        int ans = length + 1; // length + 1 is impossible
        // increasing mono queue
        Deque<Integer> monoq = new LinkedList<>();

        for (int y = 0; y < prefix.length; y++) {
            // Want opt(y) = largest x with prefix[x] <= prefix[y] - k;
            while (!monoq.isEmpty() && prefix[y] <= prefix[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && prefix[y] >= prefix[monoq.getFirst()] + k)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < length + 1 ? ans : -1;
    }
}