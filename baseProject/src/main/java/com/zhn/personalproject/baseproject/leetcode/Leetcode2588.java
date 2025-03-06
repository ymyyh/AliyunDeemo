package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2588 {
    public long beautifulSubarrays(int[] nums) {
        long count = 0;
        int temp = 0;
        Map<Integer, Integer> recordMap = new HashMap<>();
        for(int i = 0;i < nums.length; ++i){
            temp ^= nums[i];
            if(recordMap.containsKey(temp)){
                count += recordMap.get(temp);
                recordMap.put(temp, recordMap.get(temp) + 1);
            }else{
                recordMap.put(temp, 1);
            }
        }
        return count;
    }
}
