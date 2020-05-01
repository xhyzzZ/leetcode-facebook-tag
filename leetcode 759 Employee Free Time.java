//leetcode 759 Employee Free Time

/*
time: O(nlogk)
space: O()
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();

        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        schedule.forEach(e -> pq.addAll(e));

        Interval temp = pq.poll();
        while (!pq.isEmpty()) {
            if (temp.end < pq.peek().start) { // no intersect
                result.add(new Interval(temp.end, pq.peek().start));
                temp = pq.poll(); // becomes the next temp interval
            } else { // intersect or sub merged
                temp = temp.end < pq.peek().end ? pq.peek() : temp;
                pq.poll();
            }
        }
        return result;
    }
}