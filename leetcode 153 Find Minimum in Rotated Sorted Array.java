//leetcode 153 Find Minimum in Rotated Sorted Array

public class Solution {
	public int findMin(int[] num) {
		if(num == null || num.length == 0) {
			return 0;
		}
		if(num.length == 1) {
			return num[0];
		}

		int start = 0, end = num.length - 1;
		while(start < end) {
			int mid = (end - start) / 2 + start;
			if(mid > 0 && num[mid] < num[mid - 1]) {
				return num[mid];
			}
			if(num[start] <= num[mid] && num[mid] > num[end]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
 		}
 		return num[start];
	}
}