package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode26 {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        for(int i = 1;i < nums.length; ++i){
            if(nums[i] != nums[i - 1]){
                nums[count] = nums[i];
                count += 1;
            }
        }
        return count;
    }
}
