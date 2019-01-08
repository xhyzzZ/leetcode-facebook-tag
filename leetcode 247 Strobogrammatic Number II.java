//leetcode 247 Strobogrammatic Number II

/*
time: O(n^2)
space: O(n)
*/

public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, m);
    }

    public List<String> helper(int n, int m) {
    	if(n == 0) return new ArrayList<>(Arrays.asList(""));
    	if(n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
    	List<String> list = helper(n - 2, m);
    	List<String> res = new ArrayList<>();

    	for(int i = 0; i < list.size(); i++) {
    		String s = list.get(i);

    		if(n != m) res.add("0" + s + "0");

    		res.add("1" + "1");
    		res.add("6" + "9");
    		res.add("8" + "8");
    		res.add("9" + "6");
    	}

    	return res;
    }
}