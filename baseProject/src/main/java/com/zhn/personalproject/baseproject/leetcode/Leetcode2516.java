package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode2516 {
    public long[] distance(int[] nums) {
        long[] result = new long[nums.length];
        Map<Integer, List<Long>> record = new HashMap<>();
        for(int i = 0;i < nums.length; ++i){
            if(!record.containsKey(nums[i])){
                List<Long> tempList = new ArrayList<>();
                tempList.add((long) i);
                record.put(nums[i], tempList);
            }else{
                long tempSum = record.get(nums[i]).getLast();
                tempSum += i;
                record.get(nums[i]).add(tempSum);
            }
        }

        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0;i < nums.length; ++i){
            if(!count.containsKey(nums[i])){
                count.put(nums[i], 1);
            }else{
                count.put(nums[i], count.get(nums[i]) + 1);
            }
            List<Long> recordList = record.get(nums[i]);

            int pos = count.get(nums[i]) - 1;
            result[i] = ((long) i * pos - (recordList.get(pos) - i))
                    + ((recordList.getLast() - recordList.get(pos)) - (long) (recordList.size() - pos - 1) * i);
        }

        return result;
    }
}
