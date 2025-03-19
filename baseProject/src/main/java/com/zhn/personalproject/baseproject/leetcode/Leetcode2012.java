package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode2012 {
    public int sumOfBeauties(int[] nums) {
        int[] maxArr = new int[nums.length];
        int[] minArr = new int[nums.length];

        int max = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length; ++i){
            max = Math.max(max, nums[i]);
            maxArr[i] = max;
        }
        int min = Integer.MAX_VALUE;
        for(int i = nums.length - 1;i >= 0;--i){
            min = Math.min(min, nums[i]);
            minArr[i] = min;
        }

        int count = 0;
        for(int i = 1;i < nums.length - 1; ++i){
            if(maxArr[i - 1] < nums[i] && minArr[i + 1] > nums[i]){
                count += 2;
            }else if(nums[i - 1] < nums[i] && nums[i] < nums[i + 1]){
                count += 1;
            }
        }
        return count;
    }
}
