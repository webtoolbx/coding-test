package com.leetcode.quest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Quest1_BuildanArrayWithStackOperations {

    @Test
    void test() {
        System.out.println("result : " + buildArray(new int[]{1,3,4}, 4));
    }

    // Stack
    public List<String> buildArray(int[] target, int n) {
        List<String> answer = new ArrayList<>();
        int targetIdx = 0;
        for(int i = 1; i <= n; i++){
            answer.add("Push");

            if(target[targetIdx] != i){
                answer.add("Pop");
            } else {
                targetIdx++;
            }

            if(targetIdx== target.length){
                break;
            }
        }

        return answer;
    }
}
