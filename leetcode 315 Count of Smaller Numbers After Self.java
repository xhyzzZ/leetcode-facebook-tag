//leetcode 315 Count of Smaller Numbers After Self

/*
time: O(nlogn)
space: O(k)
*/

public class Solution {
    private static int lowbit(int x) { return x & (-x); }
    class FenwickTree {    
	    private int[] sums;    
	    
	    public FenwickTree(int n) {
	      sums = new int[n + 1];
	    }
	 
	    public void update(int i, int delta) {    
	      while (i < sums.length) {
	          sums[i] += delta;
	          i += lowbit(i);
	        }
	    }
	 
	    public int query(int i) {       
		    int sum = 0;
		    while (i > 0) {
		        sum += sums[i];
		        i -= lowbit(i);
		    }
		    return sum;
	    }    
	}
	  
	public List<Integer> countSmaller(int[] nums) {
	    int[] sorted = Arrays.copyOf(nums, nums.length);
	    Arrays.sort(sorted);
	    Map<Integer, Integer> ranks = new HashMap<>();
	    int rank = 0;
	    for (int i = 0; i < sorted.length; ++i)
	        if (i == 0 || sorted[i] != sorted[i - 1])
	        ranks.put(sorted[i], ++rank);
	    
	    FenwickTree tree = new FenwickTree(ranks.size());
	    List<Integer> ans = new ArrayList<Integer>();
	    for (int i = nums.length - 1; i >= 0; --i) {
		    int sum = tree.query(ranks.get(nums[i]) - 1);      
		    ans.add(tree.query(ranks.get(nums[i]) - 1));
		    tree.update(ranks.get(nums[i]), 1);
	    }
	    
	    Collections.reverse(ans);
	    return ans;
	}