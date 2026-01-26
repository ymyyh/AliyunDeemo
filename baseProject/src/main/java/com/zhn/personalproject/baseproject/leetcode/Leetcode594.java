package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        int max = 0;
        for(int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                max = Math.max(max, map.get(key) + map.getOrDefault(key + 1, 0));
            }
        }

        return max;
    }
}
