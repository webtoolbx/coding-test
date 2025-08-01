package com.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Q118_PascalsTriangle {

    @Test
    void test() {
        System.out.println("result : " + generate(1));
        System.out.println("result : " + generate(5));
        System.out.println("result : " + generate(30));
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            return List.of(List.of(1));
        } else if(numRows == 2) {
            return List.of(List.of(1), List.of(1, 1));
        }

        List<List<Integer>> result = new ArrayList<>(List.of(List.of(1), List.of(1, 1)));
        List<Integer> prevList = result.get(1);
        for(int i = 3; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            // 3 > 1, 4 > 1,2
            for (int j = 1; j < i - 1; j++) {
                int sum = prevList.get(j - 1) + prevList.get(j);
                row.add(sum);
            }
            row.add(1);
            result.add(row);
            prevList = row;
        }
        return result;
    }
}
