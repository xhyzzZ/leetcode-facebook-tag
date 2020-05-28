//leetcode 207 Course Schedule

/*
time: O(v + e)
space: O(v + e)
*/
dfs
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<Integer>());
        
        for (int[] pair : prerequisites) {
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);
        }
        
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (!dfs(i, graph, visited)) return false;
        }
        
        return true;
    }
    // states: 0 == unknown, 1 == visiting, 2 == visited
    private boolean dfs(int curr, List<List<Integer>> graph, int[] visited) {
        if (visited[curr] == 1) return false;
        if (visited[curr] == 2) return true;
        
        visited[curr] = 1;
                
        for (int next : graph.get(curr)) {
            if (!dfs(next, graph, visited)) return false;
        }
        
        visited[curr] = 2;
        return true;
    }
}
/*
time: O(v + e)
space: O(v + e)
*/

bfs not has size
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;
        // Convert graph presentation from edges to indegree of adjacent list.
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        // Indegree - how many prerequisites are needed.
        for (int[] pair : prerequisites) {
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);
            indegree[next]++;
        }
               
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // How many courses don't need prerequisites.
        int canFinishCount = 0;  
        while (!queue.isEmpty()) {
            int curr = queue.poll(); // Already finished this prerequisite course.
            canFinishCount++;
            for (int adj : graph.get(curr)) {
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    queue.offer(adj);

                }
            }
        }
        return canFinishCount == numCourses; 
    }
}

bfs has size
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;
        // Convert graph presentation from edges to indegree of adjacent list.
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        // Indegree - how many prerequisites are needed.
        for (int[] pair : prerequisites) {
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);
            indegree[next]++;
        }
               
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // How many courses don't need prerequisites.
        int canFinishCount = 0;  
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll(); // Already finished this prerequisite course.
                canFinishCount++;
                for (int adj : graph.get(curr)) {
                    indegree[adj]--;
                    if (indegree[adj] == 0) {
                        queue.offer(adj);
                    }
                }
            }
        }
        return canFinishCount == numCourses; 
    }
}