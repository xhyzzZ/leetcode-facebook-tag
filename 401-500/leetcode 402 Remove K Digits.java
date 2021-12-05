// leetcode 402 Remove K Digits

/*
time: O(n)
space: O(n)
*/

class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray()) {
            while (k > 0 && sb.length() != 0 && sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            if (sb.length() != 0 || c != '0') sb.append(c);  // Only append when it is not leading zero
        }
        if (k >= sb.length()) return "0";
        sb.setLength(sb.length() - k);  // use all remaining k
        return sb.toString();  
    }
}