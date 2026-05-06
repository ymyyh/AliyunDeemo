package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode2078 {
    public int maxDistance(int[] colors) {
        for(int i = colors.length - 1;i >= 0; --i){
            for(int j = 0;j < colors.length; ++j){
                if(j + i >= colors.length){
                    break;
                }else if(colors[j] != colors[j + i]){
                    return i;
                }
            }
        }
        return 0;
    }
}
