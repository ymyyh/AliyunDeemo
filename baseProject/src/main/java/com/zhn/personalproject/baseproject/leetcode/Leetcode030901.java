package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode030901 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int  count = 0;
        int[] flag = new int[baskets.length];
        for(int i = 0;i < fruits.length;i++){
            int pointer = 0;
            while(pointer < baskets.length){
                if(fruits[i] > baskets[pointer] || (fruits[i] <= baskets[pointer] && flag[pointer] == 1)){
                    pointer += 1;
                    continue;
                }
                break;
            }
            if(pointer == baskets.length){
                count += 1;
            }else{
                flag[pointer] = 1;
            }
        }

        return count;
    }
}
