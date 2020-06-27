//sleetcode 3 Longest Substring Without Repeating Characters


/*
time: O(n)
space: O(1)
int[26] for Letters 'a' - 'z' or 'A' - 'Z'
int[128] for ASCII
int[256] for Extended ASCII
*/

public class Solution {
    public int lengthOfLongestSubstring2(String s) {
        int[] map = new int[128];
        int start = 0, end = 0, maxLen = 0, counter = 0;

        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1] > 0) counter++;
            map[c1]++;
            
            while (counter > 0) {
                char c2 = s.charAt(start);
                if (map[c2] > 1) counter--;
                map[c2]--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
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
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
    
    

