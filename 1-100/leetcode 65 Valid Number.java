// leetcode 65 Valid Number

/*
time: O(n)
space: O(1)
*/

class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                seenDigit = true;
            } else if (curr == '+' || curr == '-') {
                // if we see a sign, and it is not the first character of the input, 
                // and does not come immediately after an exponent ("e" or "E"), 
                // then we know the number is not valid.
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (curr == 'e' || curr == 'E') {
                // An exponent must appear after a decimal number or an integer. 
                // This means if we see an exponent, we must have already seen a digit.
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false;
            } else if (curr == '.') {
                // If we see a dot appear after an exponent, the number is not valid, 
                // because integers cannot have dots.
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else {
                // Seeing anything else instantly invalidates the input.
                return false;
            }
        }
        
        return seenDigit;
    }
}