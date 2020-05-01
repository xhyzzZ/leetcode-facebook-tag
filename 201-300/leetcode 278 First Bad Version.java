//leetcode 278 First Bad Version


/*
time: O(logn)
space: O(1)
*/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
        	int mid = start + (end - start) / 2;
        	if (!isBadVersion(mid)) start = mid + 1;
        	else end = mid;
        }
        return start;
    }
}