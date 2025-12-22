package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q944_DeleteColumnstoMakeSorted {

    @Test
    void test() {
        System.out.println(minDeletionSize(new String[]{"cba","daf","ghi"}));

        System.out.println(minDeletionSize(new String[]{"a","b"}));

        System.out.println(minDeletionSize(new String[]{"zyx","wvu","tsr"}));
    }

    // #greedy
    public int minDeletionSize(String[] strs) {
        // 현재 행이 sorted 인지 확인하고 삭제하기
        int answer = 0;
        int rows = strs.length;
        int cols = strs[0].length();

        for (int c = 0; c < cols; c++) {
            for (int r = 1; r < rows; r++) {
                if (strs[r].charAt(c) < strs[r-1].charAt(c)){
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
