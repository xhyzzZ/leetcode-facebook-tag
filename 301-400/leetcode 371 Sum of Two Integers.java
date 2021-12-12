// leetrcode 371 Sum of Two Integers

/*
time: O(n)
space: O(n)
*/

public class Solution {
    public int getSum(int a, int b) {
        if (a == 0) return b;
		if (b == 0) return a;

		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
    }
}