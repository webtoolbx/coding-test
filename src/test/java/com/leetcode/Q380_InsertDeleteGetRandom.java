package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Q380_InsertDeleteGetRandom {

    @Test
    void test() {
        RandomizedSet randomizedSet = new RandomizedSet();
        Assertions.assertTrue(randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        Assertions.assertFalse(randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
        Assertions.assertTrue(randomizedSet.insert(2)); // Inserts 2 to the set, returns true. Set now contains [1,2].
        int random = randomizedSet.getRandom(); // getRandom() should return either 1 or 2.
        Assertions.assertTrue(random == 1 || random == 2);
        Assertions.assertTrue(randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
        Assertions.assertFalse(randomizedSet.insert(2)); // 2 was already in the set, so return false.
        Assertions.assertEquals(2, randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() should return 2.
    }

    class RandomizedSet {

        Set<Integer> set = null;

        public RandomizedSet() {
            set = new HashSet<>();
        }

        public boolean insert(int val) {
            if(set.contains(val)){
                return false;
            } else {
                set.add(val);
                return true;
            }
        }

        public boolean remove(int val) {
            if(set.contains(val)){
                set.remove(val);
                return true;
            } else {
                return false;
            }
        }

        public int getRandom() {
            int num = (int) (Math.random() * set.size());
            int idx = 0;
            for(int n : set){
                if(idx == num){
                    return n;
                }
                idx++;
            }
            return set.stream().findAny().get();
        }
    }

}
