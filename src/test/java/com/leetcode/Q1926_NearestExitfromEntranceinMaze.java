package com.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Q1926_NearestExitfromEntranceinMaze {

    @Test
    void test() {
        System.out.println("result : " + nearestExit(new char[][]{{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}}, new int[]{1,2}));
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        // 가장 짧은 길이니까 BFS 사용
        int width = maze[0].length;
        int height = maze.length;

        // 이번 List 에서 0이거나 width 나 height 에 닿는 경우 그걸 리턴
        List<Index> list = new ArrayList<>();
        list.add(new Index(entrance[1], entrance[0]));
        boolean[][] visited = new boolean[height][width];
        int step = -1;
        while(!list.isEmpty()){
            List<Index> nextList = new ArrayList<>();
            step++;
            for(Index index : list){
                if(index.getX() == -1 || index.getX() == width || index.getY() == -1 || index.getY() == height){
                    continue;
                }
                if('+' == maze[index.getY()][index.getX()]
                    || visited[index.getY()][index.getX()]){
                    continue;
                }
                visited[index.getY()][index.getX()] = true;

                if((index.getY() == 0 || index.getY() == height - 1
                    || index.getX() == 0 || index.getX() == width - 1)
                    && !(index.getX() == entrance[1] && index.getY() == entrance[0])){

                    return step;
                }

                nextList.add(new Index(index.getX()+1, index.getY()));
                nextList.add(new Index(index.getX()-1, index.getY()));
                nextList.add(new Index(index.getX(), index.getY()+1));
                nextList.add(new Index(index.getX(), index.getY()-1));
            }
            list = nextList;
        }

        return -1;
    }

    public class Index {
        private int x;
        private int y;
        public Index(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
    }
}
