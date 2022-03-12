// leetcode 752 Open the Lock

/*
time: O(N^2 * A^N + D) 
where, N is Number of dials (4 in our case)
A is number of alphabets (10 in our case -> 0 to 9)
D is the size of deadends.
space: O(A^N + D)
*/

class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                if (deads.contains(s)) {
                    size--;
                    continue;
                }
                if (s.equals(target)) return level;
                StringBuilder sb = new StringBuilder(s);
                for (int j = 0; j < 4; j++) {
                    char c = sb.charAt(j);
                    String s1 = sb.substring(0, j) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(j + 1);
                    String s2 = sb.substring(0, j) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(j + 1);
                    if (!visited.contains(s1) && !deads.contains(s1)) {
                        queue.offer(s1);
                        visited.add(s1);
                    }
                    if (!visited.contains(s2) && !deads.contains(s2)) {
                        queue.offer(s2);
                        visited.add(s2);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        begin.add("0000");
        end.add(target);
        int level = 0;
        Set<String> temp;
        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                temp = begin;
                begin = end;
                end = temp;
            }
            temp = new HashSet<>();
            for (String s : begin) {
                if (end.contains(s)) return level;
                if (deads.contains(s)) continue;
                deads.add(s);
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < 4; i ++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) 
                    + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) 
                    + sb.substring(i + 1);
                    if(!deads.contains(s1)) temp.add(s1);
                    if(!deads.contains(s2)) temp.add(s2);
                }
            }
            level++;
            begin = temp;
        }
        return -1;
    }
}