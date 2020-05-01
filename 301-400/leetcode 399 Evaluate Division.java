//leetcode 399 Evaluate Division

/* Graph + DFS */
/*
time: O(e + q*e)
space: O(e)
*/
public class Solution {
    public double[] calcEquation(String[][] eq, double[] vals, String[][] q) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.putIfAbsent(equations[i][0], new HashMap<>());
            map.putIfAbsent(equations[i][1], new HashMap<>());
            map.get(equations[i][0]).put(equations[i][1], values[i]);
            map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        double[] r = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            r[i] = dfs(queries[i][0], queries[i][1], 1, map, new HashSet<>());
        }
        return r;
    }
    private double dfs(String s, String t, double r, Map<String, Map<String, Double>> map, Set<String> seen) {
        if (!map.containsKey(s) || !seen.add(s)) return -1;
        // 结束条件
        if (s.equals(t)) return r;
        Map<String, Double> next = map.get(s);
        for (String c : next.keySet()) {
            double result = dfs(c, t, r * next.get(c), map, seen);
            // 回溯部分剪枝
            if (result != -1) return result;
        }
        return -1;
    }
}

/* Union find */
/*
time: O(e + q)
space: O(e)
*/
class Solution {
    public double[] calcEquation(String[][] e, double[] values, String[][] q) {
        double[] res = new double[q.length];
        Map<String, String> root = new HashMap<>();
        Map<String, Double> dist = new HashMap<>();
        for (int i = 0; i < e.length; i++) {
            String r1 = find(root, dist, e[i][0]);
            String r2 = find(root, dist, e[i][1]);
            root.put(r1, r2);
            dist.put(r1, dist.get(e[i][1]) * values[i] / dist.get(e[i][0]));
        }
        for (int i = 0; i < q.length; i++) {
            if (!root.containsKey(q[i][0]) || !root.containsKey(q[i][1])) {
                res[i] = -1.0;
                continue;
            }
            String r1 = find(root, dist, q[i][0]);
            String r2 = find(root, dist, q[i][1]);
            if (!r1.equals(r2)) {
                res[i] = -1.0;
                continue;
            }
            res[i] = (double) dist.get(q[i][0]) / dist.get(q[i][1]);
        }
        return res;
    }
    
    private String find(Map<String, String> root, Map<String, Double> dist, String s) {
        if (!root.containsKey(s)) {
            root.put(s, s);
            dist.put(s, 1.0);
            return s;
        }
        if (root.get(s).equals(s)) return s;
        String lastP = root.get(s);
        String p = find(root, dist, lastP);
        root.put(s, p);
        dist.put(s, dist.get(s) * dist.get(lastP));
        return p;
    }
}

