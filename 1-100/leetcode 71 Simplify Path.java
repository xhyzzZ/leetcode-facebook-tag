// leetcode 71 Simplify Path


/*
time: O(n)
space: O(n)
*/

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String dir : path.split("/")) {
            if (dir.equals("..")) {
                if (!stack.empty()) stack.pop();
            } else if (dir.length() > 0 && !dir.equals(".")) {
                stack.push(dir);
            }
        }
        return "/" + String.join("/", stack);
    }
}