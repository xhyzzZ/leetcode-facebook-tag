//leetcode 350 Intersection of Two Arrays II

/*
time: O(n)
space: O(n)
*/
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
        	if (nums1[i] < nums2[j]) {
        		i++;
        	} else if (nums1[i] == nums2[j]) {
        		res.add(nums1[i]);
        		i++;
        		j++;
        	} else {
        		j++;
        	}
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
        	result[i] = res.get(i);
        }
        return result;
    }
}