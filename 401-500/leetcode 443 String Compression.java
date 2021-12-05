// leetcode 443 String Compression

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int compress(char[] chars) {
        int start = 0, end = 0, count = 0;
        while (end < chars.length) {
            count++;
            if (end == chars.length - 1 || chars[end] != chars[end + 1]) {
                // We have found a difference or we are at the end of array
                chars[start] = chars[end]; // Update the character at start pointer
                start++;
                if (count != 1) {
                    // Copy over the character count to the array
                    char[] arr = String.valueOf(count).toCharArray();
                    for (int i = 0; i < arr.length; i++, start++)
                        chars[start] = arr[i];
                }
                // Reset the counter
                count = 0;
            }
            end++;
        }
        return start;
    }
}
