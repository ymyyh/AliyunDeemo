package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode3740 {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0;i < nums.length; ++i){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                List<Integer> tempList = new ArrayList<>();
                tempList.add(i);
                map.put(nums[i], tempList);
            }
        }
        int result = Integer.MAX_VALUE;
        for(List<Integer> list : map.values()){
            if(list.size() >= 3){
                for(int i = 0;i <= list.size() - 3; ++i){
                    result = Math.min(result, Math.abs(list.get(i) - list.get(i + 1)) + Math.abs(list.get(i) - list.get(i + 2)) + Math.abs(list.get(i + 1) - list.get(i + 2)));
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
