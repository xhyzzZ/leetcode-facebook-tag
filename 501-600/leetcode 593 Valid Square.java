//leetcode 593 Valid Square

/*
time: O()
space: O()
*/

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (p1[0] == p2[0] && p1[1] == p2[1]
            || p1[0] == p3[0] && p1[1] == p3[1]
            || p1[0] == p4[0] && p1[1] == p4[1]) return false;
        
        int d2 = distSq(p1, p2);  // from p1 to p2
        int d3 = distSq(p1, p3);  // from p1 to p3
        int d4 = distSq(p1, p4);  // from p1 to p4
     
        // If lengths if (p1, p2) and (p1, p3) are same, then
        // following conditions must met to form a square.
        // 1) Square of length of (p1, p4) is same as twice
        //    the square of (p1, p2)
        // 2) p4 is at same distance from p2 and p3
        if (d2 == d3 && 2 * d2 == d4) {
            int d = distSq(p2, p4);
            return (d == distSq(p3, p4) && d == d2);
        }
     
        // The below two cases are similar to above case
        if (d3 == d4 && 2 * d3 == d2) {
            int d = distSq(p2, p3);
            return (d == distSq(p2, p4) && d == d3);
        }
        
        if (d2 == d4 && 2 * d2 == d3) {
            int d = distSq(p2, p3);
            return (d == distSq(p3, p4) && d == d2);
        }
     
        return false;
    }
    
    int distSq(int[] p, int[] q) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }
}