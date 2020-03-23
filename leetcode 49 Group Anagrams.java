//leetcode 49 Group Anagrams

/*
time: O(m * n)
space: O(n)
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}

/*
time: O(m * n *logn)
space: O(n)
*/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs) {
        	char[] ch = str.toCharArray();
        	Arrays.sort(ch);
        	String s = new String(ch);
        	if (map.containsKey(s)) {
        		List<String> list = res.get(map.get(s));
        		list.add(str);
        	} else {
        		List<String> list = new ArrayList<>();
        		list.add(str);
        		map.put(s, res.size());
        		res.add(list);
        	}
        }
        return res;
    }
}