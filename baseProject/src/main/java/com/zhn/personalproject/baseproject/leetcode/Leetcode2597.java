package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode2597 {
    int count = 0;
    Map<Integer, Integer> limitNumMap = new HashMap<>();
    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> limitMap = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num - k)){
                limitMap.put(num, map.get(num - k));
            }
            if(map.containsKey(num + k)){
                limitMap.put(num, limitMap.getOrDefault(num, 0) + map.get(num + k));
            }
        }
        List<Integer> limitNumList = new ArrayList<>();
        for(int num : nums){
            if(limitMap.containsKey(num)){
                limitNumList.add(num);
            }
        }
        int temp = nums.length - limitNumList.size();
        int tempCount = (int) Math.pow(2, temp);
        dfs(0, limitNumList, k, tempCount);

        return count - 1;
    }

    void dfs(int pos, List<Integer> limitNumList, int k, int tempCount){
        if(pos >= limitNumList.size()){
            count += tempCount;
            return;
        }
        int minRes = limitNumList.get(pos) - k;
        int maxRes = limitNumList.get(pos) + k;
        if(!limitNumMap.containsKey(limitNumList.get(pos)) || limitNumMap.get(limitNumList.get(pos)) == 0) {
            limitNumMap.put(minRes, limitNumMap.getOrDefault(minRes, 0) + 1);
            limitNumMap.put(maxRes, limitNumMap.getOrDefault(maxRes, 0) + 1);
            dfs(pos + 1, limitNumList, k, tempCount);
            limitNumMap.put(minRes, limitNumMap.getOrDefault(minRes, 0) - 1);
            limitNumMap.put(maxRes, limitNumMap.getOrDefault(maxRes, 0) - 1);
        }
        dfs(pos + 1, limitNumList, k, tempCount);
    }
}
