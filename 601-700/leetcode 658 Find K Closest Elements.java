//leetcode 658 Find K Closest Elements

/*
time: O(log(n - k))
space: O()
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - k - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (Math.abs(x - arr[mid]) > Math.abs(x - arr[mid + k])) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }                
        }     
        // return subarray
        List<Integer> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            res.add(arr[lo + i]);
        }
        return res;
    }
}