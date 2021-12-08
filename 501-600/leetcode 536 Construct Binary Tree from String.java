// leetcode 536 Construct Binary Tree from String

/*
time: O(n)
space: O(h)
*/

class Solution {
    public TreeNode str2tree(String s) {
        // Base case
        if (s.length() == 0) return null;
        // Create root
        int i = 0, j = 0;
        while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '-')) j++;
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(i, j)));
        // Left child
        if (j < s.length()) {
            i = j;
            int count = 1;
            while (j + 1 < s.length() && count != 0) {
                j++;
                if (s.charAt(j) == ')') count--;
                if (s.charAt(j) == '(') count++;
            }
            root.left = str2tree(s.substring(i + 1, j));
        }
        j++;
        // Right child
        if (j < s.length()) {
            root.right = str2tree(s.substring(j + 1, s.length() - 1));
        }
        return root;
    }
}