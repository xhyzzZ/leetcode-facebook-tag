//leetcode 788 Rotated Digits

/*
time: O()
space: O()
*/

class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
        	if (isValid(i)) count++;
        }
        return count;
    }

    private boolean isValid(int N) {
    	boolean validFound = false;
    	while (N > 0) {
    		if (N % 10 == 2) validFound = true;
    		if (N % 10 == 5) validFound = true;
    		if (N % 10 == 6) validFound = true;
    		if (N % 10 == 9) validFound = true;
    		if (N % 10 == 3) return false;
    		if (N % 10 == 4) return false;
    		if (N % 10 == 7) return false;
    		N = N / 10;
    	}
    	return validFound;
    }
}