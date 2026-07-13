package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class Q1291 {

    @Test
    void testThreeSum() {
        assertThat(sequentialDigits(100, 300)).isEqualTo(List.of(123, 234));
        assertThat(sequentialDigits(1000, 13000)).isEqualTo(List.of(1234,2345,3456,4567,5678,6789,12345));
    }

    public List<Integer> sequentialDigits(int low, int high) {
        // 현재 자리수에서 최대로 만들기
        // 다음 자리수에서 최대로 만들기
        // 반복

        List<Integer> result = new ArrayList<>();

        int lowSize = String.valueOf(low).length();
        int highSize = String.valueOf(high).length();

        for(int i = lowSize; i <= highSize; i++){
            for(int j = 1; j <= 9 - i + 1; j++){
                int totalNum = 0;
                int addNum = j;
                for(int k = 0; k < i; k++){
                    totalNum *= 10;
                    totalNum += addNum;
                    addNum++;
                }
                // System.out.println(totalNum);
                if(totalNum >= low && totalNum <= high){
                    result.add(totalNum);
                }
            }
        }

        return result;
    }
}
