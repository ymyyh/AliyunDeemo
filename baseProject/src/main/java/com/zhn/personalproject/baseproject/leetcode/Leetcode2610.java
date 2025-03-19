package com.zhn.personalproject.baseproject.leetcode;

import java.util.*;

public class Leetcode2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>(map.keySet());
        while(!set.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            for(int num : set){
                tempList.add(num);
                if(map.get(num) == 1){
                    map.remove(num);
                }else{
                    map.put(num, map.get(num) - 1);
                }
            }
            result.add(tempList);
            set = new HashSet<>(map.keySet());
        }
        return result;
    }
}
