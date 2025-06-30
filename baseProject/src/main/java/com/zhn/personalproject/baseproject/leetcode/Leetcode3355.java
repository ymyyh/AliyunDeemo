package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] record = new int[nums.length];
        for(int[] arr : queries){
            record[arr[0]] -= 1;
            if(arr[1] < nums.length - 1){
                record[arr[1] + 1] += 1;
            }
        }

        int sum = 0;
        for(int i = 0;i < record.length; ++i){
            sum += record[i];
            if(nums[i] + sum > 0){
                return false;
            }
        }
        return true;
    }
}
