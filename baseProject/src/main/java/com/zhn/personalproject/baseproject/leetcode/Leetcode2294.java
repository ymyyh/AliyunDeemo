package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;

public class Leetcode2294 {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = 0;
        int result = 0;
        while(end < nums.length){
            if(nums[end] - nums[start] <= k){
                end += 1;
            }else{
                result += 1;
                end += 1;
                start = end;
            }
        }

        if(start == nums.length){
            return result;
        }else{
            return result + 1;
        }
    }
}
