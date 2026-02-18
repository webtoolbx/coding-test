package com.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Numberofsumsofconsecutivesubsequences {

    @Test
    void test() {
        Numberofsumsofconsecutivesubsequences solution = new Numberofsumsofconsecutivesubsequences();
        Assertions.assertEquals(18, solution.solution(new int[]{7, 9, 1, 1, 4}));
    }

    Set<Integer> set;

    public int solution(int[] elements) {
        set = new HashSet<>();
        for(int i = 1; i <= elements.length; i++){
            cal(elements, i);
        }
        return set.size();
    }

    // 배열에서 몇개를 고를지
    public void cal(int[] elements, int cnt){
        for(int i = 0; i < elements.length; i++){
            int sum = 0;
            int idx = i;
            int counter = cnt;
            while(counter > 0){
                sum += elements[idx];
                idx++;
                if(idx >= elements.length){
                    idx = 0;
                }
                counter--;
            }
            set.add(sum);
        }
    }
}
