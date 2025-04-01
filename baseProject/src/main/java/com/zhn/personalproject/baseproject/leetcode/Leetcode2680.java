package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode2680 {
    public long maximumOr(int[] nums, int k) {
        int[] newNums = Arrays.copyOf(nums, nums.length);
        int tag = 1;
        int count = 0;
        long sum = 0;
        Map<Integer, Integer> recordMap = new HashMap<>();
        while(tag == 1){
            tag = 0;
            for(int i = 0;i < nums.length; ++i){

                if(count == 0){
                    sum |= nums[i];
                }

                if(nums[i] != 0) {
                    recordMap.put(count, recordMap.getOrDefault(count, 0) + (nums[i] & 1));
                    nums[i] = nums[i] >> 1;
                }
                if(nums[i] != 0){
                    tag = 1;
                }
            }
            count++;

        }
        long max = 0;
        int tempCount;
        for(int i = 0;i < newNums.length; ++i){
            long tempSum = sum;
            long kNums = (long) Math.pow(2, k) * newNums[i];
            if(newNums[i] >= (int) Math.pow(2, (count - 1))){
               tempCount = 0;
                while(newNums[i] != 0){
                   if(recordMap.get(tempCount) == 1 && (newNums[i] & 1) == 1){
                       tempSum -= (long) Math.pow(2, tempCount);
                   }
                   tempCount += 1;
                   newNums[i] >>= 1;
               }

                max = Math.max(max, tempSum | kNums);
            }
        }
        return max;
    }
}
