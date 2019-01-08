//leetcode 238 Product of Array Except Self


/*
time: O(n)
space: O(n)
*/


/*
 * nums   = [1, 2, 3, 4]
 * output = product of nums[left of i] * product of nums[right of i]
 
output = [
  24, // left: init=1     nums[i]=1  right: 2 * 3 * 4 
  12, // left: 1          nums[i]=2  right: 3 * 4
  8,  // left: 1 * 2      nums[i]=3  right: 4
  6,  // left: 1 * 2 * 3  nums[i]=4  right: init=1 
]
*/
public class Solution {
	public int[] productExceptSelf(int[] nums) {
	    int leng = nums.length;
	    int[] ret = new int[leng];
	    if(leng == 0)
	        return ret;
	    int runningprefix = 1;
	    for(int i = 0; i < leng; i++){
	        ret[i] = runningprefix;
	        runningprefix *= nums[i];
	    }
	    int runningsufix = 1;
	    for(int i = leng - 1; i >= 0; i--){
	        ret[i] *= runningsufix;
	        runningsufix *= nums[i];
	    }
	    return ret;
	}
}