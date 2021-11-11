// leetcode 1650 Lowest Common Ancestor of a Binary Tree III

/*
time: O(n)
space: O(1)
*/


class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while (a != b) {
            a = a == null? q : a.parent;
            b = b == null? p : b.parent;    
        }
        return a;
    }
}