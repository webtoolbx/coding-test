package com.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class Q841_KeysandRooms {

    @Test
    void test() {
        System.out.println("result : " + canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
        System.out.println("result : " + canVisitAllRoomsSet(List.of(List.of(1), List.of(2), List.of(3), List.of())));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        // business logic
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            visited[cur] = true;
            for(int i = 0; i < rooms.get(cur).size(); i++){
                int next = rooms.get(cur).get(i);
                if(!visited[next]){
                    queue.add(next);
                }
            }
        }

        boolean result = true;
        for(boolean v : visited){
            if(!v){
                result = false;
                break;
            }
        }
        return result;
    }

    boolean[] visited;
    public boolean canVisitAllRoomsSet(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];

        // 무작정 재귀로 가볼까
        for(int i = 0; i < rooms.get(0).size(); i++){
            visit(rooms, rooms.get(0).get(i));
        }

        boolean result = true;
        for(boolean v : visited){
            if(!v){
                result = false;
                break;
            }
        }
        return result;
    }

    private void visit(List<List<Integer>> rooms, int cur){
        if(visited[cur]) return;
        visited[cur] = true;
        for(int i = 0; i < rooms.get(cur).size(); i++){
            visit(rooms, rooms.get(cur).get(i));
        }
    }
}
