package com.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

public class DoubleEndedPriorityQueue {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{0, 0}, solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}));
        Assertions.assertArrayEquals(new int[]{333, -45}, solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));
    }

    // #이중우선순위큐 #priorityQueue
    public int[] solution(String[] operations) {
        int[] answer = {};
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(String o : operations){
            String[] param = o.split(" ");
            if("I".equals(param[0])){
                map.put(Integer.valueOf(param[1]), map.getOrDefault(Integer.valueOf(param[1]), 0) + 1);
            } else if(!map.isEmpty()){
                int key = 0;
                if(Integer.valueOf(param[1]) == 1){
                    key = map.lastKey();
                } else {
                    key = map.firstKey();
                }
                int cnt = map.get(key);
                if(cnt == 1){
                    // remove
                    map.remove(key);
                } else {
                    // reduce
                    map.put(key, cnt-1);
                }
            }
        }
        if(map.isEmpty()){
            return new int[]{0, 0};
        }

        return new int[]{map.lastKey(), map.firstKey()};
    }
}
