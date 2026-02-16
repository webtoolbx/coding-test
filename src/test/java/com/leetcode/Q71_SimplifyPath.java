package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Q71_SimplifyPath {

    @Test
    void test() {
        Q71_SimplifyPath solution = new Q71_SimplifyPath();
        Assertions.assertEquals("/home", solution.simplifyPath("/home/"));
        Assertions.assertEquals("/home/foo", solution.simplifyPath("/home//foo/"));
        Assertions.assertEquals("/home/user/Pictures", solution.simplifyPath("/home/user/Documents/../Pictures"));
        Assertions.assertEquals("/", solution.simplifyPath("/../"));
        Assertions.assertEquals("/.../b/d", solution.simplifyPath("/.../a/../b/c/../d/./"));
    }

    public String simplifyPath(String path) {
        // 앞에서부터 진행해도 됨
        String[] arr = path.split("/");
        ArrayDeque<String> s = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++){
            switch (arr[i]){
                case "." -> {
                    // notthing
                }
                case ".." -> {
                    if(!s.isEmpty()){
                        s.pop();
                    }
                }
                default -> {
                    if(arr[i] != null && !arr[i].isEmpty()){
                        s.push(arr[i]);
                    }
                }
            }
        }

        List<String> list = new ArrayList<>();
        while(!s.isEmpty()){
            list.add(s.pollLast());
        }
        return "/" + String.join("/", list);
    }
}
