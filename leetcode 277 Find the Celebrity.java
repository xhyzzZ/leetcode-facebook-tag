//leetcode 277 Find the Celebrity


/*
time: O(n)
space: O(1)
*/
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
        	if (knows(candidate, i)) {
        		candidate = i;
        	}
        }

        for (int i = 0; i < n; i++) {
        	if (i == candidate) {
        		continue;
        	}
        	if (!knows(i, candidate) || knows(candidate, i)) {
        		return -1;
        	}
        }
        return candidate;
    }
}