package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Quest1_NumberofStudentsUnabletoEatLunch {

    @Test
    void test() {
        Assertions.assertEquals(0, countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
        Assertions.assertEquals(3, countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));

        Assertions.assertEquals(0, countStudents2(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
        Assertions.assertEquals(3, countStudents2(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }

    // #queue
    public int countStudents(int[] students, int[] sandwiches) {
        // 그냥 각각의 갸수 아닌가?
        // 아니네 앞에 있는 샌드위치를 처리해 줄 사람이 필요함
        Queue<Boolean> sQueue = new LinkedList<>();
        for(int s : students){
            if(s == 0){
                sQueue.add(false);
            } else {
                sQueue.add(true);
            }
        }

        Queue<Boolean> sandQueue = new LinkedList<>();
        for(int s : sandwiches){
            if(s == 0){
                sandQueue.add(false);
            } else {
                sandQueue.add(true);
            }
        }

        for(int i = 0; i < students.length; i++){
            boolean isPicked = false;
            int size = sQueue.size();
            for(int j = 0; j < size; j++){
                boolean cur = sQueue.poll();
                if(sandQueue.peek() == cur){
                    sandQueue.poll();
                    isPicked = true;
                    break;
                } else {
                    sQueue.add(cur);
                }
            }
            // 한 바퀴를 다 돌았는데도 뽑아낸게 없는 경우
            if(!isPicked){
                return sQueue.size();
            }
        }

        return 0;

        // 그냥 Map 으로 푸는게 빠를텐데 queue 로 한번 해본다.
        // Map<Integer, Integer> map = new HashMap<>();

    }

    public int countStudents2(int[] students, int[] sandwiches) {
        // 그냥 Map 으로 푸는게 빠를텐데 queue 로 한번 해본다.
        // Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;

        // 일단 존재하는 학생 정보 입력
        Map<Boolean, Integer> map = new HashMap<>();
        for(int s : students){
            if(s == 0) {
                map.put(false, map.getOrDefault(false, 0) + 1);
            } else {
                map.put(true, map.getOrDefault(true, 0) + 1);
            }
        }

        // 샌드위치 순회하면서 값이 존재하지 않으면 실패처리하고 숫자 입력
        for(int s : sandwiches){
            if(s == 0){
                int count = map.getOrDefault(false, 0);
                // 진행 불가
                if(count <= 0){
                    break;
                }
                map.put(false, count - 1);
            } else {
                int count = map.getOrDefault(true, 0);
                // 진행 불가
                if(count <= 0){
                    break;
                }
                map.put(true, count - 1);
            }
        }

        ans += map.getOrDefault(false, 0);
        ans += map.getOrDefault(true, 0);

        return ans;
    }
}
