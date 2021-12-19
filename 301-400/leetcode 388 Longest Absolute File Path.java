// leetcode 388 Longest Absolute File Path

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.isEmpty()) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxLen = 0;
        // empty level will have 0 length string
        stack.push(0); 
        for (String s : input.split("\n")) {
            // Find the last index of '\t'
            // this will return the index of '\' if '\t' present, to make index of '\t' we add 1. 
            // It also play well when there is no '\t' then it makes level
            int level = s.lastIndexOf('\t') + 1;
            // Compute the remaining length of string without '\t'
            int len = s.length() - level;
            // Remove all the level which is bigger than this because we must have evaluate the sub-string size by them
            while (stack.size() > level + 1) stack.pop();

            // Check does this is a file or not
            if (!s.contains(".")) {
                // if a sub-dir, than append its length to just higher level sub-dir
                stack.push(stack.peek() + len + 1);
            } else {
                // if its a file, compute the length of string for this file. 
                // To compute, get the level at this file is and add the length of the file
                maxLen = Math.max(maxLen, stack.peek() + len);
            }
        }
        return maxLen;
    }
}