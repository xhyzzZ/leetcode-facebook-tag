// leetcode 364 Nested List Weight Sum II

/*
time: O(n)
space: O(n)
*/

bfs
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        // Each integer get added one extra time for the mere existence of each one level under it.
        // unweighted = Running sum of all numbers

        // weighted = Running sum OF above sum
        
        // e.g.                                   unweighted        weighted
        // level 1 - integers = [2]     sum = 2     2                2
        // level 2 - integers = [1,3]   sum = 4     2 + 4            2 +  2+4
        // level 3 - integers = [2,2,1] sum = 5     2 + 4 + 5        2 +  2+4 +  2+4+5
        int unweighted = 0, weighted = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    unweighted += ni.getInteger();
                } else {
                    nextLevel.addAll(ni.getList());
                }
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }
        return weighted;
    }
}

/*
time: O(n)
space: O(n)
*/

dfs two pass
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = findMaxDepth(nestedList);
        return weightedSum(nestedList, 1, maxDepth);
    }

    private int findMaxDepth(List<NestedInteger> list) {
        int maxDepth = 1;
        
        for (NestedInteger nested : list) {
            if (!nested.isInteger()) {
                maxDepth = Math.max(maxDepth, 1 + findMaxDepth(nested.getList()));
            }
        }
        
        return maxDepth;
    }
    
    private int weightedSum(List<NestedInteger> list, int depth, int maxDepth) {
        int res = 0;
        for (NestedInteger nested : list) {
            if (nested.isInteger()) {
                res += nested.getInteger() * (maxDepth - depth + 1);
            } else {
                res += weightedSum(nested.getList(), depth + 1, maxDepth);
            }
        }
        return res;
    }
}