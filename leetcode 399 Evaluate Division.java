//leetcode 399 Evaluate Division

/* Graph + DFS */
/*
time: O(e + q*e)
space: O(e)
*/
public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i = 0; i < values.length; i++) {
        	map.putIfAbsent(equations[i][0], new HashMap<>());
        	map.putIfAbsent(equations[i][1], new HashMap<>());
        	map.get(equations[i][0]).put(equations[i][1], values[i]);
        	map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        double[] r = new double[queries.length];
        for(int i = 0; i < queries.length; i++) {
        	r[i] = dfs(queries[i][0], queries[i][1], 1, map, new HashSet<>());
        	return r;
        }

        double dfs(String s, String t, double r, Map<String, Map<String, Double>> map, Set<String> seen) {
        	if(!map.containsKey(s) || !seen.add(s)) return -1;
        	if(s.equals(t)) return r;
        	Map<String, Double> next = map.get(s);
        	for(String c : next.keySet()) {
        		double result = dfs(c, t, r * next.get(c), m, seen);
        		if(result != -1) return result;
        	}
        	return -1;
        }
    }
}

/* Union find */
/*
time: O(e + q)
space: O(e)
*/
class Solution {
  class Node {
    public String parent;
    public double ratio;
    public Node(String parent, double ratio) {
      this.parent = parent;
      this.ratio = ratio;
    }
  }
  
  class UnionFindSet {
    private Map<String, Node> parents = new HashMap<>();
    
    public Node find(String s) {
      if (!parents.containsKey(s)) return null;
      Node n = parents.get(s);
      if (!n.parent.equals(s)) {
        Node p = find(n.parent);
        n.parent = p.parent;
        n.ratio *= p.ratio;
      }
      return n;
    }
    
    public void union(String s, String p, double ratio) {
      boolean hasS = parents.containsKey(s);
      boolean hasP = parents.containsKey(p);
      if (!hasS && !hasP) {
        parents.put(s, new Node(p, ratio));
        parents.put(p, new Node(p, 1.0));
      } else if (!hasP) {
        parents.put(p, new Node(s, 1.0 / ratio));
      } else if (!hasS) {
        parents.put(s, new Node(p, ratio));
      } else {
        Node rS = find(s);
        Node rP = find(p);
        rS.parent = rP.parent;
        rS.ratio = ratio / rS.ratio * rP.ratio;
      }
    }
  }
  
  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    UnionFindSet u = new UnionFindSet();
    
    for (int i = 0; i < equations.length; ++i)
      u.union(equations[i][0], equations[i][1], values[i]);
    
    double[] ans = new double[queries.length];
    
    for (int i = 0; i < queries.length; ++i) {      
      Node rx = u.find(queries[i][0]);
      Node ry = u.find(queries[i][1]);
      if (rx == null || ry == null || !rx.parent.equals(ry.parent))
        ans[i] = -1.0;        
      else
        ans[i] = rx.ratio / ry.ratio;
    }
    
    return ans;
  }
}

