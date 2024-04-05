// TC: O(n)
// SC: O(n)

// Approach: Keep adding temperatures if they are less than the top of the stack
// Once you find a higher temperature, resolve all the lower ones

import java.util.Stack;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int current = stack.pop();
                result[current] = i - current;
            }
            stack.push(i);
        }

        return result;
    }
}