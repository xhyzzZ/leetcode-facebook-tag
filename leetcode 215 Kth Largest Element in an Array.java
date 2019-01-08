//leetcode 215 Kth Largest Element in an Array


/*
quicksort
time: O(n) average
space: O(1)
*/
public class Solution {
	public int findKthLargest(int[] nums, int k) {
		shuffle(nums);
		k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
	}

	private int partition(int[] a, int lo, int hi) {
		int pivot = a[lo];
        int pivotIndex = lo;
        lo++;
        while(lo <= hi) {
        	if(a[lo] < pivot) {
        		lo++;
        	} else if(a[hi] >= pivot) {
        		hi--;
        	} else {
        		swap(a, lo, hi);
        	}
        }
        swap(a, pivotIndex, hi);
        return hi;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void shuffle(int[] arr) {
        Random r = new Random();
        int range = arr.length;
        for(int i = 0; i < range; i++) {
            int swapIndex = r.nextInt(range);
            swap(arr, i, swapIndex);
        }
    }


    //iterative 
    public int findKthLargest(int[] A, int k) {
        k = A.length - k; // convert to index of k largest
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int i = l; // partition [l,r] by A[l]: [l,i]<A[l], [i+1,j)>=A[l]
            for (int j = l + 1; j <= r; j++)
                if (A[j] < A[l]) swap(A, j, ++i);
            swap(A, l, i);

            if (k < i) r = i - 1;
            else if (k > i) l = i + 1;
            else return A[i];
        }
        return -1; // k is invalid
    }
}