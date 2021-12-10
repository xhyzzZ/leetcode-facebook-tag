// leetcode 658 Find K Closest Elements

/*
time: O(log(n - k) + k)
space: O(1)
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // Create output in correct format
        List<Integer> res = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        
        return res;
    }
}