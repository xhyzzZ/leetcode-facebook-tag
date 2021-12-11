// leetcode 223 Rectangle Area

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) { {
        int together;
        if (ax2 <= bx1 || ax1 >= bx2 || ay1 >= by2 || ay2 <= by1) {
        	together = 0;
        } else {
        	int x = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        	int y = Math.min(ay2, by2) - Math.max(ay1, by1);
        	together = x * y;
        }
        return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - together;
    }
}