// leetcode 986 Interval List Intersections

/*
time: O(m + n)
space: O(m + n)
*/

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            // Let's check if firstList[i] intersects secondList[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if (lo <= hi) ans.add(new int[]{lo, hi});

            // Remove the interval with the smallest endpoint
            if (firstList[i][1] < secondList[j][1]) i++;
            else j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}

