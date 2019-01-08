//leetcode 49 Group Anagrams


/*
time: O(m * n *logn)
space: O(n)

*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : strs) {
        	char[] ch = str.toCharArray();
        	Arrays.sort(ch);
        	String s = new String(ch);
        	if(map.containsKey(s)) {
        		List<String> list = res.get(map.get(s));
        		list.add(str);
        	} else {
        		List<String> list = new ArrayList<>();
        		list.add(str);
        		map.put(s, res.size());
        		res.add(list);
        	}
        }
        return res;
    }
}