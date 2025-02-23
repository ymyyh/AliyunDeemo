package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2244 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int time = 0;
        for(int value : map.values()){
            if(value == 1){
                return -1;
            }
            else{
                time += value % 3 == 0 ? value / 3 : value / 3 + 1;
            }
        }
        return time;
    }
}
