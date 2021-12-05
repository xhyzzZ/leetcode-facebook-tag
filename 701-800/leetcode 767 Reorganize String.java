// leetcode 767 Reorganize String

/*
time: O(n)
space: O(26)
*/

// We construct the resulting string in sequence: at position 0, 2, 4, ... and then 1, 3, 5, ...
// In this way, we can make sure there is always a gap between the same characters
class Solution {
    public String reorganizeString(String s) {
	    int[] hash = new int[26];
	    // count letter appearance and store in hash[i]
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        int max = 0, letter = 0;
        // find the letter with largest occurence.
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (s.length() + 1) / 2) {
            return ""; 
        }

        char[] res = new char[s.length()];
        int idx = 0;
        // put the letter into even index numbe (0, 2, 4 ...) char array
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }

        // put the rest into the array
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
	}
}