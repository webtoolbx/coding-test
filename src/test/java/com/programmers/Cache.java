package com.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashSet;

public class Cache {

    @Test
    void test() {
        Cache solution = new Cache();
        Assertions.assertEquals(50, solution.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        Assertions.assertEquals(21, solution.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        Assertions.assertEquals(60, solution.solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        Assertions.assertEquals(52, solution.solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        Assertions.assertEquals(16, solution.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        Assertions.assertEquals(25, solution.solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        HashSet<String> set = new HashSet<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        int answer = 0;
        for(String city : cities){
            city = city.toLowerCase();
            if(set.contains(city)){
                answer++;
                queue.remove(city);
                queue.add(city);
            } else {
                answer += 5;
                if(queue.size() == cacheSize){
                    String data = queue.poll();
                    set.remove(data);
                }
                set.add(city);
                queue.add(city);
            }
        }


        return answer;
    }
}
