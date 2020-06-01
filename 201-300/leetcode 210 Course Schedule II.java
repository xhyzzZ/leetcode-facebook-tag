//leetcode 210 Course Schedule II

/*
time: O(v + e)
space: O(v + e)
*/

// bfs not has size
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      	if (numCourses == 0) return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int indegree[] = new int[numCourses], order[] = new int[numCourses], index = 0;
        // Indegree - how many prerequisites are needed.
        for (int[] pair : prerequisites) {
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);
            indegree[next]++;
        } 

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.offer(i);
            }
        }
            
        // How many courses don't need prerequisites. 
        int canFinishCount = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll(); 
            canFinishCount++;
            // Already finished this prerequisite course.
            for (int adj : graph.get(curr)) {
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    order[index++] = adj;
                    queue.offer(adj);
                }
            }
        }
        return (canFinishCount == numCourses) ? order : new int[0];
    }
}

// bfs has size 
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int indegree[] = new int[numCourses], order[] = new int[numCourses], index = 0;
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
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.offer(i);
            }
        }
            
        // How many courses don't need prerequisites. 
        int canFinishCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll(); 
                canFinishCount++;
                for (int adj : graph.get(curr)) {
                    indegree[adj]--;
                    if (indegree[adj] == 0) {
                        order[index++] = adj;
                        queue.offer(adj);
                    }
                }
            }
            
        }
        return (canFinishCount == numCourses) ? order : new int[0];
    }
}

/*
time: O(v + e)
space: O(v)
*/


public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] pair : prerequisites) {
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);
        }

        int[] visited = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!topologicalSort(graph, i, stack, visited)) return new int[0];
        }
        int i = 0;
        int[] result = new int[numCourses];
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }
    // 0 -> unvisited, 1 -> visiting, 2 -> visited
    private boolean topologicalSort(List<List<Integer>> graph, int v, Stack<Integer> stack, int[] visited) {
        if (visited[v] == 1) return false;
        if (visited[v] == 2) return true;
        visited[v] = 1;
        for (Integer u : graph.get(v)) {
            if (!topologicalSort(graph, u, stack, visited)) return false;
        }
        visited[v] = 2;
        stack.push(v);
        return true;
    }
}