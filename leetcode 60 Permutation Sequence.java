//leetcode 60 Permutation Sequence


/*
time: O(n)
space: O(n)
*/
public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
        	res.add(i);
        } 
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i = 1; i <= n; i++) {
        	fact[i] = fact[i - 1] * i;
        }
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for(i = n; i > 0; i--) {
        	int index = k / fact[i - 1];
        	k = k % fact[i - 1];
        	sb.append(res.get(index));
        	res.remove(index);
        }
        return sb.toString();
    }
}