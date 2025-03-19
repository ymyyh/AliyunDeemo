package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode2614 {
    public int diagonalPrime(int[][] nums) {
        int maxNum = 0;
        for(int i = 0;i < nums.length; ++i){
            for(int j = 0;j < nums.length; ++j) {
                maxNum = Math.max(maxNum, nums[i][j]);
            }
        }
        int limit = maxNum + 1;
        int[] recordArr = new int[limit];
        int record = 0;
        for(int i = 2;i <= limit / 2 + 1; ++i){
            if(recordArr[i] == 0){
                record = i * 2;
                while(record < recordArr.length){
                    recordArr[record] = 1;
                    record += i;
                }
            }
        }
        int max = 0;
        for(int i = 0;i < nums.length; ++i){
            if(recordArr[nums[i][nums.length - 1 - i]] == 0){
                max = Math.max(max, nums[i][nums.length - 1 - i]);
            }
            if(recordArr[nums[i][i]] == 0){
                max = Math.max(max, nums[nums.length - 1 - i][i]);
            }
        }

        return max;
    }
}
