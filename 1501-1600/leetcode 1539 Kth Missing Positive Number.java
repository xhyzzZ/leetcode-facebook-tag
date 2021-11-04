// leetcode 1539 Kth Missing Positive Number

/*
time: O(n)
space: O(1)
*/


class Solution {
    public int findKthPositive(int[] arr, int k) {
        int number = 1;
        for (int i = 0; i < arr.length && k > 0; ) {
            if (arr[i] == number) {
                i++;
            } else {
                k--;
            }
            number++;
        }
        if (k != 0) {
            return number + (k - 1);
        } else {
            return number - 1;
        }
    }
}