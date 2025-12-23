package com.zhn.personalproject.baseproject.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode2054 {
    public int maxTwoEvents(int[][] events) {
        Map<Integer, Integer> record = new HashMap<>();
        for(int[] event : events) {
            record.put(event[0], Math.max(record.getOrDefault(event[0], 0), event[2]));
        }
        List<Integer> list = new ArrayList<>(record.keySet()).stream().sorted().toList();

        int maxValue = 0;
        for(int index : list){
            int tempMax = 0;
            for(int[] event : events){
                if(event[1] < index){
                    tempMax = Math.max(tempMax, event[2]);
                }
                maxValue = Math.max(maxValue, tempMax + record.get(index));
            }
        }

        return maxValue;
    }
}
