package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode3635 {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] query : queries){
            for(int i = query[0];i <= query[1]; i += query[2]){
                nums[i] = (nums[i] * query[3]) % 1000000007;
            }
        }
        int result = 0;
        for(int num : nums){
            result ^= num;
        }
        return result;
    }
}
