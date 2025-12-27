package com.leetcode.quest;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

public class Quest3_ExclusiveTimeofFunctions {

    @Test
    void test() {
        System.out.println("result : " + exclusiveTime(2, List.of("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7")));
    }

    // Stack
    public int[] exclusiveTime(int n, List<String> logs) {
        // 싱글 스레드라서 한개만
        int[] spendTime = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for(String log : logs){
            String[] parts = log.split(":");

            int id = Integer.valueOf(parts[0]);
            String type = parts[1];
            int time = Integer.valueOf(parts[2]);

            if("start".equals(type)){
                // 새로운 함수가 시작되기 전까지, 현재 실행 중이던 함수에 시간 할당
                if (!stack.isEmpty()) {
                    spendTime[stack.peek()] += time - prevTime;
                }
                stack.push(id);
                prevTime = time;
            } else {
                // 종료처리
                spendTime[stack.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }


        return spendTime;
    }
}
