package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode2140 {
    public long mostPoints(int[][] questions) {
        long totalMax = 0;
        Map<Integer, Long> record = new HashMap<>();
        Map<Integer, Long> newMap = new HashMap<>();
        record.put(0, 0l);
        for(int[] arr : questions){
            for(int key : record.keySet()) {
                if (key == 0 || key == 1) {
                    newMap.put(0, Math.max(record.getOrDefault(0, 0l), record.getOrDefault(1, 0l)));
                } else {
                    newMap.put(key - 1, record.get(key));
                }
            }

            int score = arr[0];
            int br = arr[1];
            newMap.put(br ,Math.max(newMap.getOrDefault(br, 0l), record.getOrDefault(0, 0l) + score));
            record = new HashMap<>(newMap);
            newMap.clear();
        }
        for(long value : record.values()){
            totalMax = Math.max(totalMax, value);
        }
        return totalMax;
    }
}
