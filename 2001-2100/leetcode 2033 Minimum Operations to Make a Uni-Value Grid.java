// leetcode 2033 Minimum Operations to Make a Uni-Value Grid

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] arr = new int[grid.length * grid[0].length];
        int index = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                arr[index++] = grid[i][j];
            }
        }
        
        Arrays.sort(arr);
        int median = arr[(arr.length - 1) / 2];
        int res = 0;
        
        for (int num : arr) {
            if (num == median) continue;
            
            if (Math.abs(num - median) % x != 0) return -1;
            
            res += (Math.abs(num - median) / x);
        }
        
        return res;
    }
}