// leetcode 509 Fibonacci Number

/*
time: O(2^n)
space: O(n) We need space proportional to N to account for the max size of the stack
*/

recursion
public class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}

/*
time: O(n)
space: O(n)
*/

recursion + memo
class Solution {
    // Creating a hash map with 0 -> 0 and 1 -> 1 pairs
    private Map<Integer, Integer> cache = new HashMap<>(Map.of(0, 0, 1, 1));

    public int fib(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, fib(n - 1) + fib(n - 2));
        return cache.get(n);
    }
}

/*
time: O(n)
space: O(1)
*/

iterative 
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;

        int current = 0;
        int prev1 = 1;
        int prev2 = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}