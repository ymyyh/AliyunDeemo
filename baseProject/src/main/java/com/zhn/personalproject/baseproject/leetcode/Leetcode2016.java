package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode2016 {
    public int maximumDifference(int[] nums) {
        int result = Integer.MIN_VALUE;
        int min = nums[0];
        for(int i = 1;i < nums.length; ++i){
            result = Math.max(result, nums[i] - min);
            min = Math.min(min, nums.length);
        }
        return result;
    }
}
