//leetcode 339 Nested List Weight Sum

/*
time: O()
space: O(k)
*/

public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> list, int depth) {
	    int ret = 0;
	    for (NestedInteger e : list) {
	        ret += e.isInteger() ? e.getInteger() * depth : helper(e.getList(), depth + 1);
	    }
	    return ret;
	}
}