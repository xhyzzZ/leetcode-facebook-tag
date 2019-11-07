//leetcode 50 Pow(x, n)


/*
time: O(logn)
space: O(n)


*/
public class Solution {
    public double myPow(double x, int n) {
        if (n > 0) {
        	return pow(x, n);
        } else {
        	return 1.0 / pow(x, n);
        }
    }

    public static double pow(double x, int n) {
    	if (n == 0) return 1;
    	double y = pow(x, n / 2);
    	if (n % 2 == 0) { 
    		return y * y;
    	} else {
    		return y * y * x;
    	}
    }
}
