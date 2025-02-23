package com.zhn.personalproject.baseproject.leetcode;

public class Leecode1652 {
    public int[] decrypt(int[] code, int k) {
        int sum = 0;
        for(int i = 0;i < code.length; ++k){
            if(i == 0 && k >= 0){
                for(int j = 1;j <= k; ++j){
                    sum += code[j % code.length];
                }
            }
            else if(i == 0 && k < 0){
                for(int j = -1;j >= k; --j){
                    sum += code[(j + code.length) % code.length];
                }
            }
            else if(k >= 0){
                sum += code[(i + k) % code.length];
                sum -= code[i];
            }else{
                sum -= code[(i + k + code.length) % code.length];
                sum += code[i];
            }

            code[i] = sum;
        }
        return code;
    }
}
