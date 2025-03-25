package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Leetcode2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });

        int[] copy = Arrays.copyOf(queries, queries.length);
        Arrays.sort(queries);
        Map<Integer, Integer> resultMap = new HashMap<>();

        int pointer1 = 0;
        int pointer2 = 0;
        int max = 0;

        while(pointer2 < queries.length){
            if(items[pointer1][0] <= queries[pointer2]){
                max = Math.max(max, items[pointer1][1]);
                resultMap.put(queries[pointer2], max);
                if(pointer1 < items.length - 1){
                    pointer1 += 1;
                }else{
                    pointer2 += 1;
                }
            }else{
                resultMap.put(queries[pointer2], max);
                pointer2 += 1;
            }
        }

        int[] result = new int[queries.length];
        for(int i = 0;i < queries.length; ++i){
            result[i] = resultMap.getOrDefault(copy[i], 0);
        }

        return result;
    }
}
