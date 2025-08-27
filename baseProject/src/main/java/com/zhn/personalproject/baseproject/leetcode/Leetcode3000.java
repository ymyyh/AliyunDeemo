package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode3000 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int result = 0;
        int maxLength = 0;
        for(int i = 0;i < dimensions.length; ++i){
            if(dimensions[i][0] * dimensions[i][0] + dimensions[i][1] * dimensions[i][1] > maxLength){
                maxLength = dimensions[i][0] * dimensions[i][0] + dimensions[i][1] * dimensions[i][1];
                result = dimensions[i][0] * dimensions[i][1];
            }else if(dimensions[i][0] * dimensions[i][0] + dimensions[i][1] * dimensions[i][1] == maxLength){
                result = Math.max(result, dimensions[i][0] * dimensions[i][1]);
            }
        }

        return result;
    }
}
