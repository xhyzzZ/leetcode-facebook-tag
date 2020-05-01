//leetcode 126 Word Ladder II

/*
time: O()
space: O()
*/

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        // Neighbors for every node
        Map<String, List<String>> nodeNeighbors = new HashMap<>();
        // Distance of every node from the start node
        Map<String, Integer> distance = new HashMap<>();
        List<String> solution = new ArrayList<>();

        dict.add(beginWord);
        bfs(beginWord, endWord, dict, nodeNeighbors, distance);
        dfs(beginWord, endWord, dict, nodeNeighbors, distance, solution, res);
        return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance) {
        for (String str : dict) {
            nodeNeighbors.put(str, new ArrayList<>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                List<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {// Check if visited
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor))// Found the shortest path
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }

            if (foundEnd) break;
        }
    }

    // Find all next level nodes.
    private List<String> getNeighbors(String node, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] chs = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance, List<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }
}