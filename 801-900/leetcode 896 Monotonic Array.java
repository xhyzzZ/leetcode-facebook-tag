//leetcode 896 Monotonic Array

/*
time: O(n)
space: O(1)
*/

class Solution {
    public boolean isMonotonic(int[] A) {
        int inc = 1;
        int dec = 1;
        for(int i = 1; i < A.length; i++) {
            if(A[i] - A[i - 1] > 0)
                inc++;
            else if(A[i] - A[i - 1] < 0)
                dec++;
            else {
                inc++; dec++;
            }
                
        }
        return inc == A.length || dec == A.length;
    }
}