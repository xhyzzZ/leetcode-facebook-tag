// leetcode 140 Word Break II

/*
time: O(len(wordDict) ^ len(s / minWordLenInDict)) 
space: O()
*/

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> memo = new HashMap<>(); // <Starting index, rst list>
        return backtrack(s, wordDict, memo);
    }

    private List<String> backtrack(String s, List<String> wordDict, Map<String, List<String>> memo) {
    	if (memo.containsKey(s)) return memo.get(s);
    	List<String> res = new ArrayList<>();
    	for (String word : wordDict) {
    		if (s.startsWith(word)) {
                // s.substring() has a time complexity of O(n) should be o(avgWordLenInDict)
    			String next = s.substring(word.length());
    			if (next.length() == 0) res.add(word);
    			else for (String sub : backtrack(next, wordDict, memo)) res.add(word + " " + sub);
    		}
    	}
    	memo.put(s, res);
    	return res;
    }
}