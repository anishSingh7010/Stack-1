// TC: O(n)
// SC: O(n)

// Approach: Two passed on the array and find next greater element
// Dont add elements to the stack in the second pass as they were already
// processed

import java.util.Arrays;
import java.util.Stack;

class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < 2 * nums.length; i++) {
            int currentIndex = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[currentIndex]) {
                int current = stack.pop();
                result[current] = nums[currentIndex];
            }
            // push only in the first pass
            if (i < nums.length) {
                stack.push(i);
            }
        }

        return result;
    }
}