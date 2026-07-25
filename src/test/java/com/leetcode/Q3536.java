package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q3536 {

    @Test
    void testMaxProduct() {
        Q3536 solution = new Q3536();

        // Test case 1: Basic distinct digits
        Assertions.assertEquals(72, solution.maxProduct(891)); // 9 * 8 = 72
        Assertions.assertEquals(42, solution.maxProduct(67));  // 7 * 6 = 42

        // Test case 2: Duplicate digits
        Assertions.assertEquals(81, solution.maxProduct(99));  // 9 * 9 = 81
        Assertions.assertEquals(49, solution.maxProduct(777)); // 7 * 7 = 49

        // Test case 3: Single-digit input
        Assertions.assertEquals(0, solution.maxProduct(5));    // max1=5, max2=0 -> 5 * 0 = 0 (assuming problem implies at least two digits for product, or second largest is 0)

        // Test case 4: Input with zero
        Assertions.assertEquals(0, solution.maxProduct(50));   // 5 * 0 = 0
        Assertions.assertEquals(0, solution.maxProduct(0));    // 0 * 0 = 0

        // Test case 5: Multiple zeros
        Assertions.assertEquals(0, solution.maxProduct(100));  // 1 * 0 = 0

        // Test case 6: Digits in descending order
        Assertions.assertEquals(56, solution.maxProduct(876)); // 8 * 7 = 56

        // Test case 7: Digits in ascending order
        Assertions.assertEquals(56, solution.maxProduct(678)); // 8 * 7 = 56

        // Test case 8: Larger number
        Assertions.assertEquals(72, solution.maxProduct(123456789)); // 9 * 8 = 72
    }

    public int maxProduct(int n) {
        // 가장 큰 수 2개를 곱하면 되는 문제
        int max1 = 0;
        int max2 = 0;

        // Handle single digit or zero input explicitly if the problem statement implies
        // that for numbers like 5, the product of the two largest digits should be 0.
        // The current loop will correctly set max1=5, max2=0 for n=5, resulting in 0.
        // For n=0, max1=0, max2=0, resulting in 0.

        while(n > 0){
            int num = n % 10;
            n /= 10;

            if(num > max1){
                max2 = max1;
                max1 = num;
            } else if(num > max2){ // This correctly handles cases where num is between max1 and max2, or num is equal to max1.
                                   // If num == max1, it won't update max2, which is correct as we want two *distinct* largest positions or the same digit if it appears twice.
                                   // For example, 99 -> max1=9, max2=9.
                max2 = num;
            }
        }

        return max1 * max2;
    }
}
