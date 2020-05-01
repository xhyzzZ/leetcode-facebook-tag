//leetcode 609 Find Duplicate File in System

/*
time: O(n^2)
space: O()
*/

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] parts = path.split(" ");
            for (int i = 1; i < parts.length; i++) {
                int k = parts[i].indexOf("(");
                String content = parts[i].substring(k, parts[i].length() - 1);
                map.putIfAbsent(content, new LinkedList<>());
                map.get(content).add(parts[0] + "/" + parts[i].substring(0, k));
            }
        }
        List<List<String>> r = new LinkedList<>();
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                r.add(list);
            }
        }
        return r;
    }
}