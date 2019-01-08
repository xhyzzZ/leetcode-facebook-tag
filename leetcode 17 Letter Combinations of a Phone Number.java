//leetcode 17 Letter Combinations of a Phone Number

/*
time: O()
space: O()
*/

public class Solution {

	private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        combination("", digits, 0, res);
        return res;
    }

    private void combination(String prefix, String digits, int offset, List<String> res) {
    	if(offset >= digits.length()) {
    		res.add(prefix);
    		return;
    	}

    	String letters = KEYS[(digits.charAt(offset) - '0')];
    	for(int i = 0; i < letters.length(); i++) {
    		combination(prefix + letters.charAt(i), digits, offset + 1, res);
    	}
    }
}



