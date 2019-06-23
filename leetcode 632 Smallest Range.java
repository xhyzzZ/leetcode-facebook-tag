//leetcode 632 Smallest Range

/*
time: O()
space: O()
*/


class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++) {
        	max = Math.max(max, nums.get(i).get(0));
        	pq.add(new int[] {nums.get(i).get(0), i, 0});
        }
        int[] result = {pq.peek()[0], max};
        while(result[1] - result[0] != 0 && pq.peek()[2] + 1 < nums.get(pq.peek()[1]).size()) {
        	int[] curr = pq.poll();
        	pq.add(new int[] {nums.get(curr[1]).get(curr[2] + 1), curr[1], curr[2] + 1});
        	max = Math.max(max, nums.get(curr[1]).get(curr[2] + 1));
        	if(max - pq.peek()[0] < result[1] - result[0]) result = new int[] {pq.peek()[0], max};
        }
        return result;
    }
}