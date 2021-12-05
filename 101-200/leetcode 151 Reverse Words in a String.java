// leetcode 151 Reverse Words in a String

/*
time: O(n)
space: O(n)
*/

class Solution {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // remove leading spaces
        while (left <= right && s.charAt(left) == ' ') left++;

        // remove trailing spaces
        while (left <= right && s.charAt(right) == ' ') right--;

        Deque<String> deque = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        // push word by word in front of deque
        while (left <= right) {
            char c = s.charAt(left);

            if ((word.length() != 0) && (c == ' ')) {
                deque.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            left++;
        }
        deque.offerFirst(word.toString());
        return String.join(" ", deque);
    }
}