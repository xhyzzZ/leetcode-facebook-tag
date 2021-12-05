// leetcode 921 Minimum Add to Make Parentheses Valid

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0, bal = 0;
        for (int i = 0; i < s.length(); ++i) {
            bal += s.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }
        return ans + bal;
    }
}