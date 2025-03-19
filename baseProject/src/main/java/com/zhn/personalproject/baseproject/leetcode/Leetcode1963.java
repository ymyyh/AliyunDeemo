package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode1963 {
    public int minSwaps(String s) {
        int pointer1 = 0;
        int pointer2 = s.length() - 1;
        int count = 0;
        int result = 0;
        while(pointer1 < pointer2){
            while(pointer1 < pointer2 && count >= 0){
                if(s.charAt(pointer1) == '['){
                    ++count;
                }else{
                    --count;
                }
                if(count >= 0) {
                    pointer1 += 1;
                }
            }
            while(pointer1 < pointer2 && s.charAt(pointer2) == ']'){
                pointer2 -= 1;
            }
            if(pointer1 <= pointer2 && count < 0) {
                count += 1;
                result += 1;
                pointer1 += 1;
                pointer2 -= 1;
            }
        }

        return result;
    }
}
