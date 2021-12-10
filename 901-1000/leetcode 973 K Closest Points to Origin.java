// leetcode 973 K Closest Points to Origin

/*
avereage time: O(n) worst O(n ^ 2)
space: O()
The advantage of this solution is it is very efficient.
The disadvatage of this solution are it is neither an online solution nor a stable one. 
And the K elements closest are not sorted in ascending order.
*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
	    int len =  points.length, l = 0, r = len - 1;
	    while (l <= r) {
	        int mid = helper(points, l, r);
	        if (mid == k) break;
	        if (mid < k) {
	            l = mid + 1;
	        } else {
	            r = mid - 1;
	        }
	    }
	    return Arrays.copyOfRange(points, 0, k);
	}

	private int helper(int[][] A, int l, int r) {
	    int[] pivot = A[l];
	    while (l < r) {
	        while (l < r && compare(A[r], pivot) >= 0) r--;
	        A[l] = A[r];
	        while (l < r && compare(A[l], pivot) <= 0) l++;
	        A[r] = A[l];
	    }
	    A[l] = pivot;
	    return l;
	}

	private int compare(int[] p1, int[] p2) {
	    return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
	}
}

/*
time: O(NlogK)
space: O(k)
*/

class Solution {
	public int[][] kClosest(int[][] points, int k) {
	    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
	    for (int[] p : points) {
	        pq.offer(p);
	        if (pq.size() > k) {
	            pq.poll();
	        }
	    }
	    int[][] res = new int[k][2];
	    while (k > 0) {
	        res[--k] = pq.poll();
	    }
	    return res;
	}
}