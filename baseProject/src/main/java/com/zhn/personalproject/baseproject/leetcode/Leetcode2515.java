package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode2515 {
    public int closestTarget(String[] words, String target, int startIndex) {
        int dis = Integer.MAX_VALUE;
        for(int i = 0;i < words.length; ++i){
            if(target.equals(words[i])){
                dis = Math.min(Math.abs(i - startIndex), Math.min(words.length - Math.abs(i - startIndex), dis));
            }
        }
        if(dis == Integer.MAX_VALUE){
            return  -1;
        }
        return dis;
    }
}
