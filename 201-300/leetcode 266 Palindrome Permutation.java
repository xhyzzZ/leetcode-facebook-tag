//leetcode 266 Palindrome Permutation

/*
time: O(n)
space: O(n)
*/

public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
        	if(!set.contains(s.charAt(i)))
        		set.add(s.charAt(i));
        	else 
        		set.remove(s.charAt(i));
        }
        return set.size() == 0 || set.size() == 1;
    }
}