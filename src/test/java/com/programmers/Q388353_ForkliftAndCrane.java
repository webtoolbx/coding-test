package com.programmers;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Q388353_ForkliftAndCrane {

    @Test
    void theLongJump() {
        System.out.println(solution(new String[]{"AZWQY", "CAABX", "BBDDA", "ACACA"}, new String[]{"A", "BB", "A"})); // 0
    }

    public int solution(String[] storage, String[] requests) {
        int h = storage.length;
        int w = storage[0].length();

        boolean[][] deleted = new boolean[h][w];
        String[][] store = new String[h][w];

        for(int i = 0 ; i < h; i++){
            String s = storage[i];
            for(int j = 0; j < w; j++){
                store[i][j] = String.valueOf(s.charAt(j));
            }
        }

        for(String req : requests){
            if(req.length() == 2){
                req = req.substring(1);
                for(int i = 0; i < h; i++){
                    for(int j = 0; j < w; j++){
                        if(req.equals(store[i][j])){
                            deleted[i][j] = true;
                        }
                    }
                }
            } else {
                List<Pair> list = new ArrayList<>();
                for(int i = 0; i < h; i++){
                    for(int j = 0; j < w; j++){
                        if(req.equals(store[i][j]) && !deleted[i][j]){
                            if(countOut(deleted, h, w, i, j)){
                                list.add(new Pair(i, j));
                            }
                        }
                    }
                }
                for(Pair p : list){
                    deleted[p.getI()][p.getJ()] = true;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(!deleted[i][j]){
                    result++;
                }
            }
        }

        return result;
    }

    boolean connectBoundary = false;
    private boolean countOut(boolean[][] deleted,
        int height, int width, int i, int j){
        if(i == 0 || i == height-1 || j == 0 || j == width-1){
            return true;
        }

        connectBoundary = false;
        boolean[][] visited = new boolean[height][width];
        dfs(deleted, visited, height, width, i, j);

        return connectBoundary;
    }

    private void dfs(boolean[][] deleted, boolean[][] visited,
        int height, int width, int i, int j){
        if(visited[i][j] || connectBoundary){
            return;
        }
        if(i == 0 || i == height-1 || j == 0 || j == width-1){
            connectBoundary = true;
            return;
        }

        visited[i][j] = true;

        if(deleted[i+1][j]) dfs(deleted, visited, height, width, i+1, j);
        if(deleted[i][j+1]) dfs(deleted, visited, height, width, i, j+1);
        if(deleted[i-1][j]) dfs(deleted, visited, height, width, i-1, j);
        if(deleted[i][j-1]) dfs(deleted, visited, height, width, i, j-1);
    }

    public class Pair{
        private int i;
        private int j;
        public int getI(){
            return i;
        }
        public int getJ(){
            return j;
        }
        public Pair (int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
