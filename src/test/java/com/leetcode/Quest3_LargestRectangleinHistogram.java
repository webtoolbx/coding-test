package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Quest3_LargestRectangleinHistogram {

    @Test
    void test() {
        Assertions.assertEquals(10, largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        Assertions.assertEquals(4, largestRectangleArea(new int[]{2, 4}));
        Assertions.assertEquals(2, largestRectangleArea(new int[]{1, 1}));
        Assertions.assertEquals(9, largestRectangleArea(new int[]{0, 9}));
    }

    // #stack #monotonic stack
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        // 스택에는 오름차순대로 데이터를 입력한다?

        // stack top 보다 idx 가 작다면 계산을 시도한다.
        for(int i = 0; i <= heights.length; i++){
            int curHeight = i == heights.length ? 0 : heights[i];

            while(!stack.isEmpty() && curHeight < heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;

                max = Math.max(max, h*w);
            }
            stack.push(i);
        }

        return max;
    }
}
