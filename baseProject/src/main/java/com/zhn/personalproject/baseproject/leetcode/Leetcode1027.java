package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode1027 {
    public String baseNeg2(int n) {
        int num = n;
        int temp = 1;
        int count = 0;
        while(n > 0){
            if(((count & 1) == 1) && ((n & 1) == 1)){
                num += temp << 1;
                n += 2;
            }
            temp = temp<< 1;
            count += 1;
            n = n >> 1;
        }
        return Integer.toBinaryString(num);
    }
}
