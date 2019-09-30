//leetcode 49 Group Anagrams

/*
time: O(m * n)
space: O(n)
*/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) { 
                arr[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(arr);
            List<String> tempList = map.getOrDefault(key, new LinkedList<>());
            tempList.add(str);
            map.put(key, tempList);
        }
        return new LinkedList<>(map.values());
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