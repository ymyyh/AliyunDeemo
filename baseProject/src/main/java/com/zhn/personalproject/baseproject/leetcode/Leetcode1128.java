package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashMap;

public class Leetcode1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        HashMap<String, Integer> recordMap = new HashMap<>();
        for (int[] dominoe : dominoes) {
            if(dominoe[0] <= dominoe[1]){
                recordMap.put(dominoe[0] + "-" + dominoe[1], recordMap.getOrDefault(dominoe[0] + "-" + dominoe[1], 0) + 1);
            }
            else{
                recordMap.put(dominoe[1] + "-" + dominoe[0], recordMap.getOrDefault(dominoe[1] + "-" + dominoe[0], 0) + 1);
            }
        }

        for(int value : recordMap.values()){
            count += value * (value - 1) / 2;
        }
        return count;
    }
}
