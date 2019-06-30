//leetcode 1004 Max Consecutive Ones III

/*
time: O(n)
space: O(1)

Intuition
Translation:
Find the longest subarray with at most K zeros.

Explanation
For each A[j], try to find the longest subarray.
If A[i] ~ A[j] has zeros <= K, we continue to increment j.
If A[i] ~ A[j] has zeros > K, we increment i.
*/

class Solution {
    public int longestOnes(int[] A, int K) {
        int zeroCount = 0, start = 0, res = 0;
        for(int end = 0; end < A.length; end++) {
            if(A[end] == 0) zeroCount++;
            while(zeroCount > K){
                if(A[start] == 0) zeroCount--;
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}