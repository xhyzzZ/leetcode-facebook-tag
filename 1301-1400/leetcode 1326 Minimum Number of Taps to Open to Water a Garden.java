// leetcode 1326 Minimum Number of Taps to Open to Water a Garden

/*
time: O(nlogn)
space: O(n)
*/

class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int minTaps(int n, int[] ranges) {
        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
            Interval in = new Interval(i - ranges[i], i + ranges[i]);
            list.add(in);
        }
        Interval cover = new Interval(0, n);
        return leastMerge(list, cover);
    }
    
    public int leastMerge(List<Interval> list, Interval interval) {
        Collections.sort(list, (o1, o2) -> o1.start - o2.start);
        int i = 0;
        int start = interval.start;
        int count = 0;
        while (i < list.size()) {
            if (list.get(i).start > start) {
                break;
            }
            int furthest = start;
            while (i < list.size() && list.get(i).start <= start) {
                if (list.get(i).end > start) {
                    if (list.get(i).end > furthest) {
                        furthest = list.get(i).end;
                    }
                }
                i++;
            }
            count++;
            if (furthest >= interval.end) return count;
            start = furthest;
        }
        return -1;
    }
}