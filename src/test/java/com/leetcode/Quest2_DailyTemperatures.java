package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class Quest2_DailyTemperatures {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{1,1,4,2,1,1,0,0}, dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
        Assertions.assertArrayEquals(new int[]{1,1,1,0}, dailyTemperatures(new int[]{30,40,50,60}));
        Assertions.assertArrayEquals(new int[]{1,1,0}, dailyTemperatures(new int[]{30,60,90}));

        Assertions.assertArrayEquals(new int[]{1,1,4,2,1,1,0,0}, dailyTemperatures2(new int[]{73,74,75,71,69,72,76,73}));
        Assertions.assertArrayEquals(new int[]{1,1,1,0}, dailyTemperatures2(new int[]{30,40,50,60}));
        Assertions.assertArrayEquals(new int[]{1,1,0}, dailyTemperatures2(new int[]{30,60,90}));
    }

    // #Reverse
    // 빠르지만 온도의 범위가 클때는 불가능한 방법이다.
    public int[] dailyTemperatures(int[] temperatures) {
        // 뭔가 역순으로 하면 더 빠를거 같지 않아?
        int[] ans = new int[temperatures.length];
        // 해당 숫자의 가장 높은 값을 찾아야해
        // 가장 최소값을 담되 그 이상 전부를 뒤져야하네
        int[] temp = new int[101];
        // 30 -> 30에게 가장 가까운 위치 리턴, 40 -> 40에게 가장 가까운 위치 리턴
        // 100 이라는 숫자가 나오면 30~99 전부다 최신화?

        int max = 30;
        for(int i = temperatures.length - 1; i >= 0; i--){
            if(temp[temperatures[i]] > 0){
                // 가장 가까운 값이 존재한다면
                ans[i] = temp[temperatures[i]] - i;
            }
            for(int j = 30; j < temperatures[i]; j++){
                // 본인보다 작은 값들에게는 본인이 가장 가까운 값
                // 현재 index 기록
                temp[j] = i;
            }
        }
        return ans;
    }

    // #Stack
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] ans = new int[temperatures.length];

        // stack 에 있는 내용들은 짝을 찾아준다.
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }

        return ans;
    }
}
