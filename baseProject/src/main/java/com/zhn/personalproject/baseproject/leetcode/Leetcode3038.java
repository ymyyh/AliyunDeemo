package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode3038 {
    public int maxOperations(int[] nums) {
        int start = 0;
        int count = 0;
        int sum = nums[0] + nums[1];
        while(start + 1 < nums.length){
            if(nums[start] + nums[start + 1] == sum){
                count += 1;
                start += 2;
            }else{
                break;
            }
        }
        return count;
    }
}
