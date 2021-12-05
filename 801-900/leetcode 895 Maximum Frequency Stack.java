// leetcode 895 Maximum Frequency Stack

/*
time: O(1)
space: O(n)

Hash map freq will count the frequence of elements.
Hash map group is a map of stack.
If element x has n frequence, we will push x n times in group[1], group[2] .. group[n]
maxfreq records the maximum frequence.

push(x) will push x tom[++freq[x]]
pop() will pop from the group[maxfreq]

The main question then becomes: among elements with the same (maximum) frequency, 
how do we know which element is most recent? We can use a stack to query this information: 
the top of the stack is the most recent.
*/

class FreqStack {
	Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        maxfreq = Math.max(maxfreq, f);
        if (!group.containsKey(f)) group.put(f, new Stack<Integer>());
        group.get(f).add(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, maxfreq - 1);
        if (group.get(maxfreq).size() == 0) maxfreq--;
        return x;
    }
}