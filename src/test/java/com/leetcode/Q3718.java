package com.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class Q3718 {

    // 3. 실행 가능한 테스트 메소드
    @Test
    void test() {
        assertThat(missingMultiple(new int[]{8,2,3,4,6}, 2)).isEqualTo(10);
        assertThat(missingMultiple(new int[]{1,4,7,10,15}, 5)).isEqualTo(5);
    }

    public int missingMultiple(int[] nums, int k) {
        // 데이터가 나눠지는지 확인해서 미리 값 입력?
        Set<Integer> divideSet = new HashSet<>();
        for(int n : nums){
            if(n % k == 0) divideSet.add(n / k);
        }
        int result = 1;
        while(divideSet.contains(result)){
            result++;
        }
        return result * k;
    }
}
