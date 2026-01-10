package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1411_NumberofWaystoPaintN3Grid {

    @Test
    void test() {
        Assertions.assertEquals(12, numOfWays(1));
        Assertions.assertEquals(54, numOfWays(2));
        Assertions.assertEquals(246, numOfWays(3));
        Assertions.assertEquals(106494, numOfWays(7));
        Assertions.assertEquals(30228214, numOfWays(5000));
    }

    public int numOfWays(int n) {
        // 경우의 수 계산 아니야?
        // aba 패턴과
        // abc 패턴이 존재
        // aba 의 다음에는 bab, bac, cac, cab, bcb -> aba 패턴 3개, abc 패턴2개
        // abc 의 다음에는 bab, bca, cac, cab      -> aba 패턴 2개, abc 패턴2개
        long mod = 1_000_000_007;
        long aba = 6;
        long abc = 6;
        for(int i = 1; i < n; i++){
            long nextAba = (aba * 3 + abc * 2) % mod;
            long nextAbc = (aba * 2 + abc * 2) % mod;
            aba = nextAba;
            abc = nextAbc;
        }

        return (int)((abc + aba) % mod);
    }
}
