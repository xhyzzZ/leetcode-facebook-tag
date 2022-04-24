// leetcode 134 Gas Station

/*
time: O(n)
space: O(n)
*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] fuel = new int[gas.length];
        int start = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
        	fuel[i] = gas[i] - cost[i];
        	sum += fuel[i];
        	if (sum < 0) {
        		sum = 0; 
        		start = i + 1;
        		if (start == gas.length) return -1;
        	}
        }

        int res = start;
        sum = 0;
        for (int i = 0; i < gas.length; i++) {
        	if (start + i == gas.length) start = -i;
        	sum += fuel[start + i];
        	if (sum < 0) return -1;
        }
        return res;
    }
}