package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2483_MinimumPenaltyforaShop {

    @Test
    void test() {
        Assertions.assertEquals(2, bestClosingTime("YYNY"));
        Assertions.assertEquals(0, bestClosingTime("NNNNN"));
        Assertions.assertEquals(4, bestClosingTime("YYYY"));
    }

    public int bestClosingTime(String customers) {
        // 문을 닫기 전에는 Y가 많아야하고
        // 문을 닫은 뒤에는 N이 많아야한다.
        int ans = 0;
        int min = 0;

        // 처음부터 문을 닫았다고 가정한다.
        for(int i = 0; i < customers.length(); i++){
            if(customers.charAt(i) == 'Y'){
                min++;
            }
        }

        int cur = min;
        // 처음부터 끝까지 이동하면서 벌점을 피할 수 있다면 감소시킨다.
        for(int i = 0; i < customers.length(); i++){
            if(customers.charAt(i) == 'Y'){
                cur--;
            } else {
                cur++;
            }
            if(cur < min){
                min = cur;
                ans = i + 1;
            }
        }

        return ans;
    }
}
