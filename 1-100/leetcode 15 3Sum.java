//leetcode 15 3Sum

//time: O(n^2)
//space: O(n)

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
        	if (i > 0 && nums[i] = nums[i - 1]) continue; //重复
        	int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
        	while (low < high) {
        		if (nums[low] + nums[high] == sum) {
        			res.add(Arrays.asList(nums[i], nums[low], nums[high]));
        			while (low < high && nums[low] == nums[low + 1]) low++;       // skip same result
        			while (low < high && nums[high] == nums[high - 1]) high--;    // skip same result
        			high--;
        			low++;
        		} else if (nums[low] + nums[high] < sum) {
        			low++;
        		} else high--;
        	}
        }
        return res;
    }
}