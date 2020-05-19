// leetcode 1453 Maximum Number of Darts Inside of a Circular Dartboard

/*
time: O(n^3)
space: O(1)
*/

class Solution {
    class Point {
        double x;
        double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int numPoints(int[][] points, int r) {
        int ans = 1;
        int num = points.length;	
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                Point x = new Point(points[i][0], points[i][1]);
                Point y = new Point(points[j][0], points[j][1]);
                if (dist(x, y) > 2.0 * r) continue;
                Point center = GetCircleCenter(x, y, r);
                int cnt = 0;
                for (int k = 0; k < num; k++) {
                    Point m = new Point(points[k][0], points[k][1]);
                    if (dist(center, m) < 1.0 * r + Math.pow(10, -8)) cnt++;
                }

                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
    
    private double dist(Point p1, Point p2) {
	    return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
    
    private Point GetCircleCenter(Point p1, Point p2, int r) {
        Point mid = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
        double angle = Math.atan2(p1.x - p2.x, p2.y - p1.y);
        double d = Math.sqrt(r * r - Math.pow(dist(p1, mid), 2));
        return new Point(mid.x + d * Math.cos(angle), mid.y + d * Math.sin(angle));
    }
}