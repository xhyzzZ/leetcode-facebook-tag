// leetcode 1235 Maximum Profit in Job Scheduling

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        
        // storing job's details into one list 
        // this will help in sorting the jobs while maintaining the other parameters
        int length = profit.length;
        for (int i = 0; i < length; i++) {
            ArrayList<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);
            jobs.add(currJob);
        }
        jobs.sort(Comparator.comparingInt(a -> a.get(0)));

        int[] memo = new int[jobs.size() + 1];
        // marking all values to -1 so that we can differentiate 
        // if we have already calculated the answer or not
        Arrays.fill(memo, -1);
        
        // binary search will be used in startTime so store it as separate list
        for (int i = 0; i < length; i++) {
            startTime[i] = jobs.get(i).get(0);
        }
        
        return findMaxProfit(jobs, startTime, length, 0, memo);
    }
    
    private int findMaxProfit(List<List<Integer>> jobs, int[] startTime, int length, int position, int[] memo) {
        if (position == length) return 0;
        if (memo[position] != -1) return memo[position];
        
        // nextIndex is the index of next non-conflicting job
        int nextIndex = findNextJob(startTime, jobs.get(position).get(1));
        
        // find the maximum profit of our two options: skipping or scheduling the current job
        int maxProfit = Math.max(findMaxProfit(jobs, startTime, length, position + 1, memo), 
                        jobs.get(position).get(2) + findMaxProfit(jobs, startTime, length, nextIndex, memo));
        
        // return maximum profit and also store it for future reference (memoization)
        memo[position] = maxProfit;
        return memo[position] = maxProfit;
    }

    private int findNextJob(int[] startTime, int lastEndingTime) {
        int start = 0, end = startTime.length - 1, nextIndex = startTime.length;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (startTime[mid] >= lastEndingTime) {
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nextIndex;
    }
}