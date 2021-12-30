// leetcode 824 Goat Latin

/*
time: O(n)
space: O(n)
*/

public class Solution {
    public String toGoatLatin(String sentence) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        String res = "";
        int i = 0, j = 0;
        for (String w : sentence.split("\\s")) {
            res += ' ' + (vowels.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)) + "ma";
            for (j = 0, i++; j < i; j++) {
                res += "a";
            }
        };
        return res.substring(1);
    }
}