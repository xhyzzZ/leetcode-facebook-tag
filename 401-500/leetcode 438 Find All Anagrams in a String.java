// leetcode 438 Find All Anagrams in a String

/*
time: O(|s| + |p|)
space: O(128)
*/

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;

        int[] map = new int[128];
        for (char c : p.toCharArray()) map[c]++;
        
        int start = 0, end = 0, count = p.length();
        int len = Integer.MAX_VALUE;
        
        while (end < s.length()) {
            // move right everytime, if the character exists in p's hash, decrease the count
            // current hash value >= 1 means the character is existing in p
            char c1 = s.charAt(end);
            if (map[c1] >= 1) count--;
            map[c1]--;

            // when the count is down to 0, means we found the right anagram
            // then add window's left to result list
            if (count == 0) res.add(start);
            
            // if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            // ++ to reset the hash because we kicked out the left
            // only increase the count if the character is in p
            if (end - start + 1 == p.length()) {
                char c2 = s.charAt(start);
                if (map[c2] >= 0) count++;
                map[c2]++;

                start++;
            }
            end++;
        }
        return res;
    }
}