//leetcode 166 Fraction to Recurring Decimal


/*
time: O(n)
space: O(n)
*/
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
	    String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
	    long num = Math.abs((long) numerator);
	    long den = Math.abs((long) denominator);
	    result.append(sign);
	    result.append(num / den);
	    long remainder = num % den;
	    if (remainder == 0)
	        return result.toString();
	    result.append(".");
	    HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
	    while (!hashMap.containsKey(remainder)) {
	        hashMap.put(remainder, result.length());
	        result.append(10 * remainder / den);
	        remainder = 10 * remainder % den;
	    }
	    int index = hashMap.get(remainder);
	    result.insert(index, "(");
	    result.append(")");
	    return result.toString().replace("(0)", "");
    }
}