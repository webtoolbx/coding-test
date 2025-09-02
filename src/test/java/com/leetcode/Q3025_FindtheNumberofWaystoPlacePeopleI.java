package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q3025_FindtheNumberofWaystoPlacePeopleI {

    @Test
    void test() {
        System.out.println("result : " + numberOfPairs(new int[][]{{1,1},{2,2},{3,3}}));
    }

    public int numberOfPairs(int[][] points) {
        // 그냥 무작정하면 time limit 걸릴거 같은데
        int answer = 0;
        for(int i = 0; i < points.length; i++){
            for(int j = i+1; j < points.length; j++){
                if(points[i][0] > points[j][0] && points[i][1] > points[j][1]){
                    continue;
                }
                if(points[i][0] < points[j][0] && points[i][1] < points[j][1]){
                    continue;
                }

                int minx = Math.min(points[i][0], points[j][0]);
                int maxx = Math.max(points[i][0], points[j][0]);
                int miny = Math.min(points[i][1], points[j][1]);
                int maxy = Math.max(points[i][1], points[j][1]);

                // valid
                boolean valid = true;
                for(int k = 0; k < points.length; k++){
                    if(k == i || k == j) continue;
                    if(points[k][0] >= minx && points[k][0] <= maxx && points[k][1] <= maxy && points[k][1] >= miny){
                        valid = false;
                        break;
                    }
                }
                if(valid) answer++;
            }
        }

        return answer;
    }
}
