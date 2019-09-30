// leetcode 202 Happy Number

/*
time: O()
space: O()
*/

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
	    int sum, remain;
		while (set.add(n)) {
			sum = 0;
			while (n > 0) {
			    remain = n % 10;
				sum += remain * remain;
				n /= 10;
			}

			if (sum == 1) {
				return true;
			} else {
				n = sum;
			}

		}
		return false;
    }
}