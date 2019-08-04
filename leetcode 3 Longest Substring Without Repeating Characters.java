//sleetcode 3 Longest Substring Without Repeating Characters


/*
time: O(n)
space: O(1)
*/

public class Solution {
    public int lengthOfLongestSubstring2(String s) {
        int[] map = new int[128];
        int start = 0, end = 0, maxLen = 0, counter = 0;

        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1] > 0) counter++;
            map[c1]++;
            end++;

            while (counter > 0) {
                char c2 = s.charAt(start);
                if (map[c2] > 1) counter--;
                map[c2]--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }
}


public class Solution {
	//Hashmap
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
        	if (map.containsKey(s.charAt(i))) {
        		j = Math.max(j, map.get(s.charAt(i)) + 1); 
        	}
        	map.put(s.charAt(i), i);
        	max = Math.max(max, i - j + 1);
        }
        return max;
    }
}

    
//HashSet
public class Solution {
    //a b c a b c d e
    // j = 0, i = 3 -> j = 1
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) return 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            } else {
                set.add(s.charAt(i));
                res = Math.max(res, set.size());
            }
        }
        return res;
    }
}
    
    

