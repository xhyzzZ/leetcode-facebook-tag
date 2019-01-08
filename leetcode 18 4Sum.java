//leetcode 18 4Sum


//time: O(n^3)
//space: O(n)
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4) return res;
        Arrays.sort();
        for(int i = 0; i < nums.length - 3; i++) {
        	if(i > 0 && nums[i] == nums[i - 1]) continue;
        	for(int j = i + 1; j < nums.length - 2; j++) {
        		if(j > i + 1 && nums[j] == nums[j - 1]) continue;
        		int low = j + 1, high = nums.length - 1;
        		while(low < high) {
        			int sum = nums[i] + nums[j] + nums[low] + nums[high];
        			if(sum == target) {
        				res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
        				while(low < high && nums[low] == nums[low + 1]) low++;
        				while(low < high && nums[high] == nums[high - 1]) high--;
        				high--;
        				low++;
        			} else if(sum < target) {
        				low++;
        			} else high--;
        		}
        	}
        	return res;
        }
    }
}