// leetcode 901 Online Stock Span

/*
time: O(n)
space; O(1)
*/

class StockSpanner {
	private Stack<int[]> stack;
    public StockSpanner() {
    	stack = new Stack<>();
    }
    
    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            res += stack.pop()[1];
        stack.push(new int[] {price, res});
        return res;
    }
}