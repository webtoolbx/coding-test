package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q56_MergeIntervals {

    @Test
    void test() {
        Q56_MergeIntervals solution = new Q56_MergeIntervals();

        int[][] input1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected1 = {{1, 6}, {8, 10}, {15, 18}};
        Assertions.assertArrayEquals(expected1, solution.merge(input1));

        int[][] input2 = {{1, 4}, {4, 5}};
        int[][] expected2 = {{1, 5}};
        Assertions.assertArrayEquals(expected2, solution.merge(input2));
    }

    public int[][] merge(int[][] intervals) {
        // 겹치는 구간 다 더하기?
        // 그러면 첫번째 요소로 다 정렬해버리고 합칠거 합치면 될거 같은데?
        // 합쳐진 요소가 몇개인지 정확히 알 수 없으므로 List 로 계산해두고 리턴할때 처리
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int cnt = intervals.length;
        for(int i = 0; i < intervals.length; i++){
            if (intervals[i] == null) continue;
            for(int j = i+1; j < intervals.length; j++){
                if(intervals[j] != null){
                    if(intervals[i][1] >= intervals[j][0]){
                        intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                        intervals[j] = null;
                        cnt--;
                    } else {
                        break;
                    }
                }
            }
        }

        int[][] answer = new int[cnt][2];
        int idx = 0;
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i] != null){
                answer[idx] = intervals[i];
                idx++;
            }
        }

        return answer;
    }

}
