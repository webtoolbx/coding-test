package com.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q3740 {

    @Test
    void test() {
        // 1. 기본 테스트 (문제 예시)
        // 1의 인덱스: [0, 2, 3] -> |0-2| + |2-3| + |0-3| = 2 + 1 + 3 = 6
        assertThat(minimumDistance(new int[]{1, 2, 1, 1, 3})).isEqualTo(6);

        // 2. 숫자가 3개 미만인 경우 (결과 -1)
        assertThat(minimumDistance(new int[]{1, 2, 1})).isEqualTo(-1);

        // 3. 정확히 3개인 경우
        // 1의 인덱스: [0, 1, 2] -> |0-1| + |1-2| + |0-2| = 1 + 1 + 2 = 4
        assertThat(minimumDistance(new int[]{1, 1, 1})).isEqualTo(4);

        // 4. 4개 이상인 경우 (최솟값이 나오는 조합 선택)
        // 1의 인덱스: [0, 1, 5, 6]
        // [0,1,5] -> |0-1| + |1-5| + |0-5| = 1 + 4 + 5 = 10
        // [1,5,6] -> |1-5| + |5-6| + |1-6| = 4 + 1 + 5 = 10
        assertThat(minimumDistance(new int[]{1, 1, 2, 3, 2, 1, 1})).isEqualTo(10);

        // 5. 빈 배열인 경우
        assertThat(minimumDistance(new int[]{})).isEqualTo(-1);
    }

    public int minimumDistance(int[] nums) {
        // 똑같은거 3개 최소 거리
        // map 에 담아서 각각 비교해서 리턴
        int result = Integer.MAX_VALUE;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for(List<Integer> list : map.values()){
            if(list.size() < 3) continue;

            for(int i = 2; i < list.size(); i++){
                int d1 = list.get(i) - list.get(i-1);
                int d2 = list.get(i) - list.get(i-2);
                int d3 = list.get(i-1) - list.get(i-2);
                result = Math.min(result, d1 + d2 + d3);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
