package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q3027_FindtheNumberofWaystoPlacePeopleII {

    @Test
    void test() {
        System.out.println("result : " + numberOfPairs(new int[][]{{1,1},{2,2},{3,3}}));
    }

    public int numberOfPairs(int[][] points) {
        int answer = 0;

        for(int i = 0; i < points.length; i++){
            for(int j = i+1; j < points.length; j++){
                if((points[i][0] > points[j][0] && points[i][1] > points[j][1])
                    || (points[i][0] < points[j][0] && points[i][1] < points[j][1])){
                    continue;
                }

                int minX = Math.min(points[i][0], points[j][0]);
                int maxX = Math.max(points[i][0], points[j][0]);
                int minY = Math.min(points[i][1], points[j][1]);
                int maxY = Math.max(points[i][1], points[j][1]);
                boolean valid = true;
                for(int k = 0; k < points.length; k++){
                    if(k == i || k == j) continue;
                    if((points[k][0] >= minX && points[k][0] <= maxX)
                        && (points[k][1] >= minY && points[k][1] <= maxY)){
                        valid = false;
                        break;
                    }
                }
                if(valid) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
