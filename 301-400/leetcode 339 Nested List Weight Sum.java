// leetcode 339 Nested List Weight Sum

/*
time: O(n) N be the total number of nested elements in the input list
space: O(n)
*/

dfs
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> list, int depth) {
	    int res = 0;
	    for (NestedInteger e : list) {
	        res += e.isInteger() ? e.getInteger() * depth : helper(e.getList(), depth + 1);
	    }
	    return res;
	}
}

/*
time: O(n) N be the total number of nested elements in the input list
space: O(n)
*/

bfs
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);

        int depth = 1;
        int total = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nested = queue.poll();
                if (nested.isInteger()) {
                    total += nested.getInteger() * depth;
                } else {
                    queue.addAll(nested.getList());
                }
            }
            depth++;
        }
        return total;
    }
}
