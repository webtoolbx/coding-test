package com.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class RotatingBrackets {

    @Test
    void test() {
        RotatingBrackets solution = new RotatingBrackets();
        Assertions.assertEquals(3, solution.solution("[](){}"));
        Assertions.assertEquals(2, solution.solution("}]()[{"));
        Assertions.assertEquals(0, solution.solution("[)(]"));
        Assertions.assertEquals(0, solution.solution("}}}"));
    }

    public int solution(String s) {
        // 전체를 순회하면서 매번 올바른 괄호인지 판단하면 O(n^2) 일텐데
        // O(n) 에 해결할 수 있는 방법이 있을까?
        int n = s.length();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            int idx = i;
            boolean isValid = true;
            for (int j = 0; j < n; j++) {
                char c = s.charAt(idx);
                if (c == '[' || c == '(' || c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    char open = stack.poll();
                    if (c == ']') {
                        if (open != '[') {
                            isValid = false;
                            break;
                        }
                    } else if (c == ')') {
                        if (open != '(') {
                            isValid = false;
                            break;
                        }
                    } else if (c == '}') {
                        if (open != '{') {
                            isValid = false;
                            break;
                        }
                    }
                }

                // System.out.println(idx);
                // System.out.println(stack.toString());
                idx++;
                if (idx == n) idx = 0;
            }
            if (stack.isEmpty() && isValid) {
                answer++;
            }
        }
        return answer;
    }
}
