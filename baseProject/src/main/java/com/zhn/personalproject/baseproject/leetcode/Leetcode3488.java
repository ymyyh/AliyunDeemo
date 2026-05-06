package com.zhn.personalproject.baseproject.leetcode;

import java.util.*;

public class Leetcode3488 {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int[] newNums = new int[nums.length * 3];
        for(int i = 0;i < newNums.length; ++i){
            if(i < nums.length){
                newNums[i] = nums[i];
            }else if(i < nums.length * 2){
                newNums[i] = nums[i - nums.length];
            }else{
                newNums[i] = nums[i - nums.length * 2];
            }
        }

        Map<Integer, Integer> record = new HashMap<>();
        int[] leftRecord = new int[newNums.length];
        int[] rightRecord = new int[newNums.length];
        Arrays.fill(leftRecord, -1);
        Arrays.fill(rightRecord, -1);

        for(int i = 0;i < newNums.length; ++i){
            if(record.containsKey(newNums[i]) && record.get(newNums[i]) != i - nums.length && record.get(newNums[i]) != (i - nums.length * 2)){
                leftRecord[i] = record.get(newNums[i]);
            }
            record.put(newNums[i], i);
        }

        record.clear();
        for(int i = newNums.length - 1;i >= 0; --i){
            if(record.containsKey(newNums[i]) && record.get(newNums[i]) != nums.length + i && record.get(newNums[i]) != (i + nums.length * 2)){
                rightRecord[i] = record.get(newNums[i]);
            }
            record.put(newNums[i], i);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0;i < queries.length; ++i){
            int pos = queries[i];
            int leftDis = leftRecord[pos] == -1 ? Integer.MAX_VALUE : Math.min(pos - leftRecord[pos], newNums.length - (pos - leftRecord[pos]));
            int rightDis = rightRecord[pos] == -1 ? Integer.MAX_VALUE : Math.min(rightRecord[pos] - pos, newNums.length - (rightRecord[pos] - pos));

            result.add(Math.min(leftDis, rightDis) == Integer.MAX_VALUE ? -1 : Math.min(leftDis, rightDis));
        }

        return result;
    }
}















