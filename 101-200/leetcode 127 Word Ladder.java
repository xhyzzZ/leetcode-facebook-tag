//leetcode 127 Word Ladder

/*
time: O(n * 26^l/2)
space: O(n)
*/

/*
bidirectional BFS
双向bfs，设计两个set存放两遍遍历的单词，遍历最短set中的每个单词
对每个单词的每个字母进行替换，如果替换的字母在dict中，那么加入一个新的set中并赋值给原set
*/
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
	    if (!dict.contains(endWord)) return 0;
	    
	    Set<String> q1 = new HashSet<>();
	    Set<String> q2 = new HashSet<>();
	    q1.add(beginWord);
	    q2.add(endWord);
	    
	    int l = beginWord.length();
	    int steps = 0;
	    
	    while (!q1.isEmpty() && !q2.isEmpty()) {
	        ++steps;
	      	// always expend the smaller queue first
	        if (q1.size() > q2.size()) {
		        Set<String> tmp = q1;
		        q1 = q2;
		        q2 = tmp;
	        }
	      	// 临时set
	        Set<String> temp = new HashSet<>();
	      
	        for (String w : q1) {        
	        	char[] chs = w.toCharArray();
	        	for (int i = 0; i < l; ++i) {
		          	char ch = chs[i];
		          	for (char c = 'a'; c <= 'z'; ++c) {
			            chs[i] = c;
			            String t = new String(chs);         
			            if (q2.contains(t)) return steps + 1;            
			            if (!dict.contains(t)) continue;            
			            dict.remove(t);        
			            temp.add(t);
	            	}
	            	// 还原
	          		chs[i] = ch;
	        	}
	      	}
	      	//赋值给q1
	      	q1 = temp;
	    }
	    return 0;
    }
}