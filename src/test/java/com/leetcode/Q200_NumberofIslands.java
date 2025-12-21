package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Q200_NumberofIslands {

    @Test
    void test() {
        Assertions.assertEquals(numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }), 1);
    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                // 여기선 방문 여부만 체크하고 답을 1 올린다.
                if(!visited[i][j]){
                    if(grid[i][j] == '1'){
                        ans++;
                    }
                    bfs(visited, grid, new Pair(j, i));
                }
            }
        }

        return ans;
    }

    // 여기서 이미 visited 인 애들은 제외하고
    // 여기랑 연관되어 있는 애들은 모두 visited 로 바꿔버린다.
    public void bfs(boolean[][] visited, char[][] grid, Pair pair){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(pair);
        int maxX = grid[0].length;
        int maxY = grid.length;

        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            int x = cur.getX();
            int y = cur.getY();

            if(!visited[y][x]){
                if(grid[y][x] == '1'){
                    // 상하좌우 다 넣어준다
                    if(y != 0){
                        queue.add(new Pair(x, y-1));
                    }
                    if(y != maxY - 1){
                        queue.add(new Pair(x, y+1));
                    }
                    if(x != 0){
                        queue.add(new Pair(x-1, y));
                    }
                    if(x != maxX - 1){
                        queue.add(new Pair(x+1, y));
                    }
                }
                visited[y][x] = true;
            }
        }
    }

    public class Pair {
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }

        public void setX(int x){
            this.x = x;
        }

        public void setY(int y){
            this.y = y;
        }
    }
}
