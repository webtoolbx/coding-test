package com.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class Q1846 {

    @Test
    void test() {
        assertThat(maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1})).isEqualTo(2);
        assertThat(maximumElementAfterDecrementingAndRearranging(new int[]{1,2,3,4,1})).isEqualTo(4);
    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // 그냥 서로 다른 숫자 개수 구하는거 아닌가?
        // 2개면 -> 2, 3개면 -> 3, 5개면 -> 5
        // 큰 숫자가 많으면 낮출 수가 있네

        // 정렬해서 순차적으로 꺼내기
        Arrays.sort(arr);

        int num = 0;
        for(int n : arr){
            // num+1 로 만들어야 하기 때문에 n > num 인지 확인
            if(n > num){
                num++;
            }
        }

        return num;
    }
}
