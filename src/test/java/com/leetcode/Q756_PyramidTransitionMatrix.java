package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Q756_PyramidTransitionMatrix {

    @Test
    void test() {
        Assertions.assertEquals(true, pyramidTransition("BCD", List.of("BCC","CDE","CEA","FFF")));
    }

    // #DP
    Map<String, List<String>> map;
    Set<String> notSet;
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // map key : String 앞에 2개, value : List<String> 으로 반복
        map = new HashMap<>();
        notSet = new HashSet<>();

        allowed.forEach(o -> {
            String key = o.substring(0, 2);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(o.substring(2));
            map.put(key, list);
        });

        return DFS(bottom, "", 0);
    }

    private boolean DFS(String current, String next, int index){
        // 이미 실패한 사례인 경우 false
        if(notSet.contains(current)){
            return false;
        }
        // next 가 다 채워진 경우에 다음 단계로 넘어간다.
        if(current.length() == index+1){
            if(DFS(next, "", 0)){
                return true;
            }
            notSet.add(next);
            return false;
        }

        // map 을 index 내용대로 조회하여 붙여서 조회한다.
        List<String> list = map.get(current.substring(index, index+2));
        if(list == null){
            return false;
        }
        if(current.length() == 2){
            return true;
        }
        for(String c : list){
            if(DFS(current, next + c, index + 1)){
                return true;
            }
        }
        return false;
    }

    /* 풀기는 했으나, 속도는 괜찮으나 메모리 이슈가 있을 수 있다.
    Map<String, List<String>> map;
    Set<String> notSet;
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // 1. 바텀의 길이가 그렇게 크지는 않긴한데 아래서 부터 쌓을 수 밖에 없나?
        // 밑에서부터 하면 DFS를 적용해서 방법이 하나만 가능해도 되는거잖아?
        // map key : String 앞에 두개, value : List<String> 으로 반복

        map = new HashMap<>();
        notSet = new HashSet<>();
        for(String a : allowed){
            String key = a.substring(0,2);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(a.substring(2));
            map.put(key, list);
        }

        return DFS(bottom);
    }

    // 현재 층 정보
    public boolean DFS(String row){
        if(notSet.contains(row)){
            return false;
        }

        // !!다음 row를 모두 만들어서 리턴
        // 다음 row를 어떻게 만들것인가

        // 해결책: 다음 층을 한 번에 다 만들지 말고, 한 글자씩 결정하면서 바로 재귀(DFS)를 들어가는 방식이 더 효율적입니다.
        // 이렇게 하고 싶었는데 방법이 생각나지 않았다....
        List<String> rowList = new ArrayList<>();
        for(int i = 0; i < row.length() - 1; i++){
            List<String> list = map.get(row.substring(i, i+2));

            if(list != null){
                if(i == 0){
                    if(row.length() == 2){
                        return true;
                    }
                    for(String c : list){
                        rowList.add(c);
                    }
                } else {
                    List<String> newList = new ArrayList<>();
                    for(String c : list){
                        for(String curRow : rowList){
                            newList.add(curRow + c);
                        }
                    }
                    rowList = newList;
                }
            } else {
                notSet.add(row);
                return false;
            }
        }

        for(String newRow : rowList){
            if(DFS(newRow)){
                return true;
            }
        }

        notSet.add(row);
        return false;
    }*/
}
