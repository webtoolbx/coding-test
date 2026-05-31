package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q6 {

    @Test
    void test() {
        Q6 solution = new Q6();

        // 예제 1: 기본 케이스 (numRows = 3)
        // P   A   H   N
        // A P L S I I G
        // Y   I   R
        Assertions.assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3));

        // 예제 2: 기본 케이스 (numRows = 4)
        // P     I    N
        // A   L S  I G
        // Y A   H R
        // P     I
        Assertions.assertEquals("PINALSIGYAHRPI", solution.convert("PAYPALISHIRING", 4));

        // 예제 3: 행이 1개일 때 (변환 없이 그대로 반환되어야 함)
        Assertions.assertEquals("A", solution.convert("A", 1));
        Assertions.assertEquals("HELLO", solution.convert("HELLO", 1));

        // 예제 4: 문자열 길이가 행의 수보다 작을 때 (변환 없이 그대로 반환되어야 함)
        Assertions.assertEquals("AB", solution.convert("AB", 3));
    }

    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() < numRows) return s;

        // 배열에 순차적으로 입력
        int length = s.length();

        // 초기화
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goingDown = false;

        for(char c : s.toCharArray()){
            rows[currRow].append(c);

            if(currRow == 0 || currRow == numRows - 1){
                goingDown = !goingDown;
            }

            currRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
