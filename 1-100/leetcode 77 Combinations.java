// leetcode 77 Combinations

/*
time: O(n^min(k,n-k))
space: O(n)
*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int start) {
    	if (k == 0) {
    		res.add(new ArrayList<>(list));
    		return;
    	}
    	for (int i = start; i <= n; i++) {
    		list.add(i);
    		helper(res, list, n, k - 1, i + 1);
    		list.remove(list.size() - 1);
    	}
    }
}