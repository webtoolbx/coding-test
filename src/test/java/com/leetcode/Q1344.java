package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Q1344 {

    @Test
    void test() {
        assertThat(angleClock(12, 30)).isEqualTo(165.0);
        assertThat(angleClock(3, 30)).isEqualTo(75.0);
        assertThat(angleClock(3, 15)).isEqualTo(7.5);
        assertThat(angleClock(4, 50)).isEqualTo(155.0);
        assertThat(angleClock(12, 0)).isEqualTo(0.0);
    }

    public double angleClock(int hour, int minutes) {
        // 작은 각도 구하기?
        // 분침에 의해 움직이는 시침 값을 구해야함

        // 분침 360 / 60 = 6
        // 6 * minutes
        // 시침 360 / 12 = 30
        // 30 * hour + 1/2 * minutes

        // 분침에 의해 움직이는 시침 값
        // 30 도가 60이라는 값에 이동 1/2
        // 30 분이면 15도
        // 180 - 90 - 15 = 75
        double m = 6 * minutes;
        double h = 30 * hour + 0.5 * minutes;

        double angle = Math.abs(h - m);
        return angle > 180.0 ? 360.0 - angle : angle;
    }
}
