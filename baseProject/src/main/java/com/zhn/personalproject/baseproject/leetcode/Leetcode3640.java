package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode3640 {
    public long maxSumTrionic(int[] nums) {
        long result = Long.MIN_VALUE;
        long tag = 0;
        long sum = 0;
        int start = 0;
        int end = 0;
        for(int i = 1;i < nums.length; ++i){
            if(nums[i - 1] > nums[i]){
                if(tag == 0){
                    sum = nums[i - 1] + nums[i];
                    start = i - 1;
                }else{
                    sum += nums[i];
                }
                tag = 1;
            }else{
                if(tag == 1){
                    end = i - 1;
                    if(start - 1 >= 0 && nums[start - 1] < nums[start]
                            && end + 1 < nums.length && nums[end] < nums[end + 1]){
                        sum += nums[start - 1] + nums[end + 1];
                        result = Math.max(result, sum);

                        start = start - 2;
                        while(start >= 0 && nums[start] < nums[start + 1] && nums[start] > 0){
                            sum += nums[start];
                            result = Math.max(result, sum);
                            start -= 1;
                        }

                        end = end + 2;
                        while(end < nums.length && nums[end - 1] < nums[end]){
                            sum += nums[end];
                            result = Math.max(result, sum);
                            end += 1;
                        }
                    }
                }
                tag = 0;
            }
        }
        return result;
    }
}
