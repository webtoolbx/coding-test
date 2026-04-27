package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Q1391_CheckifThereisaValidPathinaGrid {

    @Test
    void testHasValidPath() {
        Assertions.assertTrue(hasValidPath(new int[][]{
                {2, 4, 3},
                {6, 5, 2}
        }));

        Assertions.assertFalse(hasValidPath(new int[][]{
                {1, 2, 1},
                {1, 2, 1}
        }));

        Assertions.assertFalse(hasValidPath(new int[][]{
                {1, 1, 2}
        }));
    }

    int w;
    int h;

    int[] moveX = new int[]{1, 0, -1, 0};
    int[] moveY = new int[]{0, 1, 0, -1};

    boolean[][] visited;

    public boolean hasValidPath(int[][] grid) {
        // 유효한지 찾는 것이기 때문에 DFS > BFS
        // 방문 여부를 기록하여 재방문 방지
        w = grid[0].length;
        h = grid.length;
        visited = new boolean[grid.length][grid[0].length];
        return visit(grid, 0, 0);
    }

    private boolean visit(int[][] grid, int curX, int curY){
        if(curX == w - 1 && curY == h - 1){
            return true;
        }
        visited[curY][curX] = true;

        List<Integer> list = getPath(grid, curX, curY);

        for(int i : list){
            int nx = curX + moveX[i];
            int ny = curY + moveY[i];

            if(nx < 0 || ny < 0 || nx == w || ny == h || visited[ny][nx]){
                continue;
            }

            // 받을 수 있는 곳이 이어져 있는지 봐야함
            List<Integer> nextList = getPath(grid, nx, ny);
            if(i == 0){
                if(!nextList.contains(2)){
                    continue;
                }
            } else if(i == 1){
                if(!nextList.contains(3)){
                    continue;
                }
            } else if(i == 2){
                if(!nextList.contains(0)){
                    continue;
                }
            } else {
                if(!nextList.contains(1)){
                    continue;
                }
            }

            if(visit(grid, nx, ny)){
                return true;
            }
        }

        return false;
    }

    private List<Integer> getPath(int[][] grid, int x, int y){
        switch(grid[y][x]){
            case 1 : return List.of(0, 2);
            case 2 : return List.of(1, 3);
            case 3 : return List.of(1, 2);
            case 4 : return List.of(0, 1);
            case 5 : return List.of(2, 3);
            case 6 : return List.of(0, 3);
        }
        return null;
    }
}