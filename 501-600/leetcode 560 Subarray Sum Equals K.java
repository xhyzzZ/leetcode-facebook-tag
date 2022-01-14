// leetcode 560 Subarray Sum Equals K

/*
time: O(n)
space: O(n)
*/

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        // for those (sum - k) == 0 calculations which are valid subarrays but need to get counted
        preSum.put(0, 1);

        // 1. sum[i, j] = sum[0, j] - sum[0, i - 1]  -->  sum[0, i - 1] = sum[0, j] - sum[i, j]
        // 2.     k           sum      hashmap-key   -->   hashmap-key  =  sum - k
        // 3. now, we have k and sum.  
        // As long as we can find a sum[0, i - 1], we then get a valid subarray
        // which is as long as we have the hashmap-key,  we then get a valid subarray
        // 4. Why don't map.put(sum[0, i - 1], 1) every time ?
        // if all numbers are positive, this is fine
        // if there exists negative number, there could be preSum frequency > 1
        
        // our target is: current sum - previous sum = k
        // so sum - k = previous sum (which is stored in the map)
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if (preSum.containsKey(sum - k)) {
        		res += preSum.get(sum - k);
        	}
        	preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}