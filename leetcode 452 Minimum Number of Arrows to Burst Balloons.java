//leetcode 452 Minimum Number of Arrows to Burst Balloons

/*
time: O(nlogn)
space: O(1)
*/

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
        	if (arrowPos >= points[i][0]) continue;
        	arrowCnt++;
        	arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}