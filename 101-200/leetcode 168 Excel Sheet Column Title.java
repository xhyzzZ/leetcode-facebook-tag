//leetcode 168 Excel Sheet Column Title


/*
time: O(n)
space: O(n)
*/
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            n--;
            result.append((char)('A' + n % 26));
            n /= 26;
        }
        return res.reverse().toString();
    }
}