//leetcode 70 Climbing Stairs


/*
time: O(n)
space: O(1) / O(n)
*/
public class Solution {
	public int climbStairs(int n) {
		if(n <= 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 2;

		int one_step_before = 2;
		int two_steps_before = 1;
		int all_ways = 0;

		for(int i = 2; i < n; i++) {
			all_ways = one_step_before + two_steps_before;
			two_steps_before = one_step_before;
			one_step_before = all_ways;
		}
		return all_ways;
	}
}

public class Solution {
	public int climbStairs(int n) {
	    if(n == 0 || n == 1 || n == 2) {return n;}
	    int[] mem = new int[n];
	    mem[0] = 1;
	    mem[1] = 2;
	    for(int i = 2; i < n; i++){
	        mem[i] = mem[i-1] + mem[i-2];
	    }
	    return mem[n-1];
	}
}