//leetcode 140 Word Break II

/*
time: O()
space: O()
*/

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return backtrack(s, wordDict, new HashMap<String, List<String>>());
    }

    public List<String> backtrack(String s, List<String> wordDict, Map<String, List<String>> mem) {
    	if (mem.containsKey(s)) return mem.get(s);
    	List<String> res = new ArrayList<>();
    	for (String word : wordDict) {
    		if (s.startsWith(word)) {
    			String next = s.substring(word.length());
    			if (next.length() == 0) res.add(word);
    			else for (String sub : backtrack(next, wordDict, mem)) res.add(word + " " + sub);
    		}
    	}
    	mem.put(s, res);
    	return res;
    }
}