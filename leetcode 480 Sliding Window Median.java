//leetcode 480 Sliding Window Median

/*
time: O(nlogk)
space: O()
*/

public class Solution {
	public double[] medianSlidingWindow(int[] nums, int k) {
	    double[] result = new double[nums.length - k + 1];
	    TreeSet<Integer> left = getSet(nums);
	    TreeSet<Integer> right = getSet(nums);
	    for(int i = 0; i < nums.length; i++) {
	        if(left.size() <= right.size()) {
	            right.add(i);
	            int m = right.first();
	            right.remove(m);
	            left.add(m);
	        } else {
	            left.add(i);
	            int m = left.last();
	            left.remove(m);
	            right.add(m);
	        }
	        
	        
	        if(left.size() + right.size() == k) {
	            double med;
	            if(left.size() == right.size())
	                med = ((double)nums[left.last()] + nums[right.first()]) / 2;
	            else if(left.size() < right.size())
	                med = nums[right.first()];
	            else
	                med = nums[left.last()];
	                
	            int start = i - k + 1;    
	            result[start] = med;    
	            
	            if(!left.remove(start))
	                right.remove(start);
	        }
	    }
	    return result;
	}

	private static TreeSet<Integer> getSet(int[] nums) {
	    return new TreeSet<>(new Comparator<Integer>() {
	        public int compare(Integer a, Integer b) {
	            return nums[a] == nums[b] ? a - b : nums[a] < nums[b] ? -1 : 1;
	        }
	    });
	}
}

