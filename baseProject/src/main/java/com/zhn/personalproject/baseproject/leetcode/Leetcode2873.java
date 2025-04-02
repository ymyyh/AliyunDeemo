package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode2873 {
    public long maximumTripletValue(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];

        int tempMax = 0;
        for(int i = 0;i < nums.length; ++i){
            pre[i] = tempMax;
            tempMax = Math.max(tempMax, nums[i]);
        }
        tempMax = 0;
        for(int i = nums.length - 1;i >= 0; --i){
            post[i] = tempMax;
            tempMax = Math.max(tempMax, nums[i]);
        }


        long max = 0;
        for(int i = 1;i < nums.length - 1; ++i){
            max = Math.max(max, ((long)(pre[i] - nums[i])) * ((long)post[i]));
        }
        return max;
    }
}
