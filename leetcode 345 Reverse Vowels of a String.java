//leetcode 345 Reverse Vowels of a String


/*
time: O(n)
space: O(1)
*/

class Solution {
    public String reverseVowels(String s) {
        char[] list = s.toCharArray();
        Set<Character> vowels = new HashSet<>
        (Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));
        for (int i = 0, j = list.length - 1; i < j; ) {
            if (!vowels.contains(list[i])) {
                i++;
                continue;
            }
            if (!vowels.contains(list[j])) {
                j--;
                continue;
            }
            char temp = list[i];
            list[i] = list[j];
            list[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(list);
    }
}