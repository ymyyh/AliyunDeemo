package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode030903 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int start = 0;
        int count = 0;
        int limit = Integer.MAX_VALUE;
        int[] flag = new int[baskets.length];
        for(int i = 0;i < fruits.length;i++){
            if(fruits[i] >= limit || start == -1){
                count += 1;
                continue;
            }
            int pointer = start;
            start = -1;
            while(pointer < baskets.length){
                if(start == -1 && flag[i] == 0){
                    start = pointer;
                }
                if(fruits[i] > baskets[pointer] || (fruits[i] <= baskets[pointer] && flag[pointer] == 1)){
                    pointer += 1;
                    continue;
                }
                if(fruits[i] <= baskets[pointer] && flag[pointer] == 0){
                    break;
                }
            }
            if(pointer == baskets.length){
                count += 1;
                limit = Math.max(limit, fruits[i]);
            }else{
                flag[pointer] = 1;
                if(start == -1){
                    start = pointer + 1;
                }
            }
        }

        return count;
    }
}
