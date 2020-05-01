//leetcode 214 Shortest Palindrome

/*
time: O()
space: O()
*/

public class Solution {
	public String shortestPalindrome(String s) {
	    String temp = s + "#" + new StringBuilder(s).reverse().toString();
	    int[] table = getTable(temp);

	    return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
	}

	public int[] getTable(String s) {
	    int[] table = new int[s.length()];

	    int index = 0;
	    for (int i = 1; i < s.length(); ) {
	        if (s.charAt(index) == s.charAt(i)) {
	            table[i] = ++index;
	            i++;
	        } else {
	            if (index > 0){
	                index = table[index - 1];
	            } else {
	                index = 0;
	                i++;
	            }
	        }
	    }
	    return table;
	}
}