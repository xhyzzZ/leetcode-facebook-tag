//leetcode 772 Basic Calculator III

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int calculate(String s) {
        if (s == null) {
            return 0;
        }    
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            q.offer(c);
        }
        q.offer('+');
        return cal(q);
    }
    
    private int cal(Queue<Character> q) {
        char sign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            char c = q.poll();
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            } else if (c == '(') {
                num = cal(q);
            } else {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
                if (c == ')') {
                    break;
                }
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}