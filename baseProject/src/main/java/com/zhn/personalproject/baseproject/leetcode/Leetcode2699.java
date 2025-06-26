package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;

public class Leetcode2699 {
    public int[][] divideArray(int[] nums, int k) {
        int[][] result = new int[nums.length / 3][3];
        Arrays.sort(nums);
        for(int i = 0;i < nums.length; i += 3){
            if(nums[i + 2] - nums[i] > k){
                return new int[0][];
            }
            result[i / 3][0] = nums[i];
            result[i / 3][1] = nums[i + 1];
            result[i / 3][2] = nums[i + 2];
        }
        return result;
    }
}
