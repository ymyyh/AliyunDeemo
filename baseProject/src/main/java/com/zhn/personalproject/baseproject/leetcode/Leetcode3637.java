package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode3637 {
    public boolean isTrionic(int[] nums) {
        if(nums.length <= 3){
            return false;
        }
        int pos = 1;
        int tag = 0;
        while(pos < nums.length && nums[pos - 1] < nums[pos]){
            pos += 1;
            tag = 1;
        }

        if(tag == 0){
            return false;
        }

        tag = 0;
        while(pos < nums.length && nums[pos - 1] > nums[pos]){
            pos += 1;
            tag = 1;
        }

        if(tag == 0){
            return false;
        }

        tag = 0;
        while(pos < nums.length && nums[pos - 1] < nums[pos]){
            pos += 1;
            tag = 1;
        }

        if(pos == nums.length && tag == 1){
            return true;
        }else{
            return false;
        }
    }
}