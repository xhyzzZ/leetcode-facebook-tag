// leetcode 735 Asteroid Collision

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // 4 scenarios: 1.+ + 2.- - 3.+ - 4.- +
        // when collision happens: only 3 which is + -
        Stack<Integer> stack = new Stack<>();
        for (int cur : asteroids) {
            if (cur > 0) { // previous one does not matter, no collision forever
                stack.push(cur);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && -cur > stack.peek()) { // destroy the previous positive one(s) 
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(cur);
                } else if (stack.peek() == -cur) {
                    stack.pop();
                }
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
