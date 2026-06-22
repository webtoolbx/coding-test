package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Q1189 {

    @Test
    void test() {
        assertThat(maxNumberOfBalloons("nlaebolko")).isEqualTo(1);
        assertThat(maxNumberOfBalloons("loonbalxballpoon")).isEqualTo(2);
        assertThat(maxNumberOfBalloons("leetcode")).isEqualTo(0);
    }

    public int maxNumberOfBalloons(String text) {
        // b 1
        // a 1
        // n 1
        // l 2
        // o 2
        int a = 0, b = 0, n = 0, l = 0, o = 0;
        for(char c : text.toCharArray()){
            switch (c){
                case 'a' -> a++;
                case 'b' -> b++;
                case 'n' -> n++;
                case 'l' -> l++;
                case 'o' -> o++;
            }
        }

        o = o / 2;
        l = l / 2;

        int result = Integer.MAX_VALUE;
        result = Math.min(result, a);
        result = Math.min(result, b);
        result = Math.min(result, n);
        result = Math.min(result, l);
        result = Math.min(result, o);

        return result;
    }
}
