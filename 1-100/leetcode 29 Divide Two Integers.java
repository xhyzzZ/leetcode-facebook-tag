//leetcode 29 Divide Two Integers

/*
1. + -
2. 越界
3. = 0 3 / 5
4. 正常
5. 3 / 0 在java异常机制中

time: O(logn)
space: O(logn)
*/
public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1; //正负号，正数为1
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) sign = -1;
        long ldividend = Math.abs((long)dividend); //越界
        long ldivisor = Math.abs((long)divisor);
        if (ldividend < ldivisor || ldividend == 0) return 0;
        long lresult = divide(ldividend, ldivisor);
        int res = 0;
        if (lresult > Integer.MAX_VALUE) {
        	res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else res = (int)(sign * lresult);
        return res;
    }

    public long divide(long ldividend, long ldivisor) {
    	if (ldividend < ldivisor) return 0;
    	long sum = ldivisor;
    	long multiple = 1;
        /* 可以等于可以不等于，不等于空间复杂度为O(logn) 加上等号小于O(logn)*/ 
    	while ((sum + sum) < ldividend) {
    		sum += sum;
    		multiple += multiple;
    	}
    	return multiple + divide(ldividend - sum, ldivisor);
    }
}
