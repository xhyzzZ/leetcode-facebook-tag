//leetcode 267 Palindrome Permutation II

/*
time: O()
space: O()
*/

class Solution {
    private List<String> list = new ArrayList<>();

	public List<String> generatePalindromes(String s) {
	    int numOdds = 0; // How many characters that have odd number of count
	    int[] map = new int[256]; // Map from character to its frequency
	    for (char c : s.toCharArray()) {
	        map[c]++;
	        numOdds = (map[c] & 1) == 1 ? numOdds+1 : numOdds-1;
	    }
	    if (numOdds > 1)   return list;
	    
	    String mid = "";
	    int length = 0;
	    for (int i = 0; i < 256; i++) {
	        if (map[i] > 0) {
	            if ((map[i] & 1) == 1) { // Char with odd count will be in the middle
	                mid = "" + (char)i;
	                map[i]--;
	            }
	            map[i] /= 2; // Cut in half since we only generate half string
	            length += map[i]; // The length of half string
	        }
	    }
	    generatePalindromesHelper(map, length, "", mid);
	    return list;
	}
	private void generatePalindromesHelper(int[] map, int length, String s, String mid) {
	    if (s.length() == length) {
	        StringBuilder reverse = new StringBuilder(s).reverse(); // Second half
	        list.add(s + mid + reverse);
	        return;
	    }
	    for (int i = 0; i < 256; i++) { // backtracking just like permutation
	        if (map[i] > 0) {
	            map[i]--;
	            generatePalindromesHelper(map, length, s + (char)i, mid);
	            map[i]++;
	        } 
	    }
	}
}