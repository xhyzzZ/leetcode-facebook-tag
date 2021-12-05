// leetcode 1209 Remove All Adjacent Duplicates in String II

/*
time: O(n)
space: O(n)
*/

class Solution {
    class Point {
        char c;
        int count;
        public Point(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Point> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                Point p = stack.peek();
                if (p.c == c) {
                    p.count++;
                    if (p.count == k) stack.pop();
                } else {
                    stack.push(new Point(c, 1));
                }
            } else {
                stack.push(new Point(c, 1));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Point p = stack.pop();
            int count = p.count;
            while (count > 0) {
                count--;
                sb.append(p.c);
            }
        }
        return sb.reverse().toString();
    }
}