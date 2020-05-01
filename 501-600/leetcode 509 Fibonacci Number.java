//leetcode 509 Fibonacci Number

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int fib(int N) {
        if(N <= 1)
            return N;
		int a = 0, b = 1;
		while(N-- > 1) {
			int sum = a + b;
			a = b;
			b = sum;
		}
        return b;
    }
}