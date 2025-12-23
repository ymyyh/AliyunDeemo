package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;

public class Leetcode3074 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);

        int pointer = capacity.length - 1;
        int count = 0;
        int sum = Arrays.stream(apple).sum();
        while(sum > 0){
            sum -= capacity[pointer];
            pointer--;
            count++;
        }

        return count;
    }
}
