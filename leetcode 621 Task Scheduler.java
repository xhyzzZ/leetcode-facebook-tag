//leetcode 621 Task Scheduler


/*
time: O(n)
space: O(1)
*/
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] storage = new int[26];
        for (char c : tasks) {
            storage[(c - 'A')]++;
        }
        int max = 0;
        int count = 1;
        for (int num : storage) {
            if (num == 0) {
                continue;
            }
            if (max < num) {
                max = num;
                count = 1;
            } else if (max == num) {
                count++;
            }
        }
        int space = (n + 1) * (max - 1) + count;
        return (space < tasks.length) ? tasks.length : space;
    }
}