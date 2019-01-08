//sleetcode 3 Longest Substring Without Repeating Characters


/*
time: O(n)
space: O(1)
*/
public class Solution {
	//Hashmap
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s == null) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
        	if(map.containsKey(s.charAt(i))) {
        		j = Math.max(j, map.get(s.charAt(i)) + 1); 
        	}
        	map.put(s.charAt(i), i);
        	max = Math.max(max, i - j + 1);
        }
        return max;
    }
    //HashSet

    //a b c a b c d e
    // j = 0, i = 3 -> j = 1
    public int lengthOfLongestSubstring(String s) {
    	if(s.length() == 0 || s == null) return 0;
    	HashSet<Character> set = new HashSet<>();
    	int res = 0;
    	for(int i = 0, j = 0; i < s.length(); i++) {
    		if(set.contains(s.charAt(i))) {
    			set.remove(s.charAt(j++));
    		} else {
    			set.add(s.charAt(i));
    			res = Math.max(res, set.size());
    		}
    	}
    	return res;
    }

}