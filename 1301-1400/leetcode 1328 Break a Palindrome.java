// leetcode 1328 Break a Palindrome

/*
time: O(n)
space: O(n)
*/

class Solution {
    public String breakPalindrome(String palindrome) {
        int length = palindrome.length();
        if (length == 1) return "";

        char[] chars = palindrome.toCharArray();
        
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return String.valueOf(chars);
            }
        }
        
        chars[length - 1] = 'b';
        return String.valueOf(chars);
    }
}