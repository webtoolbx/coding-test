package com.leetcode;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2126 {

    @Test
    void test() {
        // 예제 1: 성공하는 케이스 (mass = 10, asteroids = [3, 9, 19, 5, 21])
        // 정렬 후: [3, 5, 9, 19, 21]
        // 10 + 3 = 13 -> 13 + 5 = 18 -> 18 + 9 = 27 -> 27 + 19 = 46 -> 46 + 21 = 67 (모두 파괴 가능)
        int[] asteroids1 = {3, 9, 19, 5, 21};
        Assertions.assertTrue(asteroidsDestroyed(10, asteroids1));

        // 예제 2: 실패하는 케이스 (mass = 5, asteroids = [4, 9, 23, 4])
        // 정렬 후: [4, 4, 9, 23]
        // 5 + 4 = 9 -> 9 + 4 = 13 -> 13 + 9 = 22 -> 22 < 23 (파괴 불가능)
        int[] asteroids2 = {4, 9, 23, 4};
        Assertions.assertFalse(asteroidsDestroyed(5, asteroids2));

        // 예제 3: 오버플로우가 발생하는 케이스 (작성하신 오버플로우 로직 검증)
        // int 범위를 넘어가서 mass가 음수가 되더라도 다음 소행성들을 모두 파괴할 수 있어야 함
        int[] overflowAsteroids = {100000, 100000, Integer.MAX_VALUE};
        Assertions.assertTrue(asteroidsDestroyed(Integer.MAX_VALUE - 10, overflowAsteroids));
    }

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // 소행성 정렬하고 행성이랑 비교?
        Arrays.sort(asteroids);
        for(int asteroid : asteroids){
            if(mass < asteroid){
                return false;
            }
            mass += asteroid;
            // 양수 2개를 더 했는데 Overflow 된 경우 int 범위를 벗어났으므로
            // 이후에 들어오는 소행성들보다는 무조건 큼
            if(mass < 0){
                return true;
            }
        }

        return true;
    }
}
