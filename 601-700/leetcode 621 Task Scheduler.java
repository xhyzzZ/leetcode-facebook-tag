// leetcode 621 Task Scheduler

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // frequencies of the tasks
        int[] frequencies = new int[26];
        for (int t : tasks) {
            frequencies[t - 'A']++;
        }

        // max frequency
        int max = 0;
        for (int f : frequencies) {
            max = Math.max(max, f);
        }
        
        // count the most frequent tasks
        int mostFreqTasks = 0;
        for (int f : frequencies) {
            if (f == max) mostFreqTasks++;
        }
        
        return Math.max(tasks.length, (max - 1) * (n + 1) + mostFreqTasks);
    }
}