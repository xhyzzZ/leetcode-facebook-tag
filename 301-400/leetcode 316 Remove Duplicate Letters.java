// leetcode 316 Remove Duplicate Letters

/*
time: O(n)
space: O(n)
*/

class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        HashSet<Character> seen = new HashSet<>();

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c -'a']++;
        }

        for (char c : s.toCharArray()){
            count[c -'a']--;
            // we can only try to add c if it's not already in our solution
            // this is to maintain only one of each character
            if (!seen.contains(c)) {
                // if the last letter in our solution:
                //     1. exists
                //     2. is greater than c so removing it will make the string smaller
                //     3. it's not the last occurrence
                // we remove it from the solution to keep the solution optimal
                while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
}