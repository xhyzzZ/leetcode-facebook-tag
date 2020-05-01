//leetcode 364 Nested List Weight Sum II

/*
time: O(n)
space: O()
*/

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int prevSum = 0, totalSum = 0;
        Deque<NestedInteger> queue = new ArrayDeque<>();
        for (NestedInteger ni : nestedList) {
            queue.offerLast(ni);
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size(), levelSum = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger current = queue.pollFirst();
                if (current.isInteger()) {
                    levelSum += current.getInteger();
                } else {
                    for (NestedInteger ni : current.getList()) {
                        queue.offerLast(ni);
                    }
                }
            }
            prevSum += levelSum;
            totalSum += prevSum;
        }
        return totalSum;
    }
}