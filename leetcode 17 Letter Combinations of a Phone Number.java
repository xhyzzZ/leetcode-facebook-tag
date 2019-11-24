//leetcode 17 Letter Combinations of a Phone Number

/*
time: O(4^n)
space: O(4^n)
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<String>();
        if (digits == null || digits.length() == 0) return queue;
        queue.add("");
        String[] letters = new String[] {"", "", "abc", "def", "ghi", "jkl", 
                                        "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            int cur = digits.charAt(i) - '0';
            // View the length of the top element of the LinkedList
            while (queue.peek().length() == i) {
                // move each element out
                String str = queue.remove();
                // Traversing x corresponding string of characters
                char[] candidates = letters[cur].toCharArray();
                for (char chr : candidates) {
                    queue.add(str + chr);
                }
            }
        }
        return queue;
    }
}

// time: O(k^n)
// space: O(k^n)
// k^n ( k = average length of string in KEYS and n is the length of digits.)
dfs
public class Solution {
	private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", 
                                            "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        combination("", digits, 0, res);
        return res;
    }

    private void combination(String prefix, String digits, int index, List<String> res) {
    	if (index >= digits.length()) {
    		res.add(prefix);
    		return;
    	}

    	String letters = KEYS[(digits.charAt(index) - '0')];
    	for (int i = 0; i < letters.length(); i++) {
    		combination(prefix + letters.charAt(i), digits, index + 1, res);
    	}
    }
}



