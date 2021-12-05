// leetcode 616 Add Bold Tag in String

/*
time: N is the length of s, M is the length of dict, L is the average length of each word in dict. The time complexity is O(NML)
space: O(N)
*/

class Solution {
    public String addBoldTag(String s, String[] words) {
        boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
        	for (String word : words) {
        		if (s.startsWith(word, i)) {
        			end = Math.max(end, i + word.length());
        		}
        	}
        	bold[i] = end > i;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        	if (!bold[i]) {
        		res.append(s.charAt(i));
        		continue;
        	}
        	int j = i;
        	while (j < s.length() && bold[j]) j++;
        	res.append("<b>" + s.substring(i, j) + "</b>");
        	i = j - 1;
        }
        return res.toString();
    }
}