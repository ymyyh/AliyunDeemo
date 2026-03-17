package com.zhn.personalproject.baseproject.leetcode;

public class Leecode0208_1 {
    public int dominantIndices(int[] nums) {
        double sum = 0;
        for(int num : nums){
            sum += num;
        }
        int count = 0;
        for(int i = 0;i < nums.length - 1; ++i){
            sum -= nums[i];
            if((double) nums[i] > (sum / ((double) nums.length - 1 - i))){
                count++;
            }
        }
        return count;
    }
}
