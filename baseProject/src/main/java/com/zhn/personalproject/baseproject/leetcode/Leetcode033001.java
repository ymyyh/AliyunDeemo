package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode033001 {
    int min = 0;
    public int[] minCosts(int[] cost) {
        int[] result = new int[cost.length];
        for(int i = 0;i < cost.length;i++){
            min = Math.min(cost[i], min);
            result[i] = min;
        }
        return result;
    }
}
