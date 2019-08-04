//leetcode 17 Letter Combinations of a Phone Number

/*
time: O()
space: O()
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
            while (queue.peek().length() == i) {
                String str = queue.remove();
                char[] candidates = letters[cur].toCharArray();
                for (char chr : candidates) {
                    queue.add(str + chr);
                }
            }
        }
        return queue;
    }
}


dfs
public class Solution {
	private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", 
                                            "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        combination("", digits, 0, res);
        return res;
    }

    private void combination(String prefix, String digits, int offset, List<String> res) {
    	if (offset >= digits.length()) {
    		res.add(prefix);
    		return;
    	}

    	String letters = KEYS[(digits.charAt(offset) - '0')];
    	for (int i = 0; i < letters.length(); i++) {
    		combination(prefix + letters.charAt(i), digits, offset + 1, res);
    	}
    }
}



