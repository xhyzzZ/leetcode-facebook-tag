//leetcode 344 Reverse String

/*
time: O(n)
space: O(n)
*/
public class Solution {
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0; 
        int j = s.length() - 1;
        while(i < j) {
        	char temp = word[i];
        	word[i] = word[j];
        	word[j] = temp;
        	i++;
        	j--;
        }
        return new String(word);
    }
}