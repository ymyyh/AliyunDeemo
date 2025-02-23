package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int record1 = 0;
        int length1 = 0;
        int maxLength = 0;
        int pointer1 = 0;
        List<Integer> posList1 = new ArrayList<>();

        int record2 = 0;
        int length2 = 0;
        int pointer2 = 0;
        List<Integer> posList2 = new ArrayList<>();
        for(int i = 0;i < answerKey.length(); ++i){
            if(answerKey.charAt(i) == 'T'){
                length1 += 1;
                maxLength = Math.max(length1, maxLength);
            }
            else if(record1 < k){
                record1 += 1;
                length1 += 1;
                maxLength = Math.max(length1, maxLength);
                posList1.add(i);
            }else{
                length1 = i - posList1.get(pointer1);
                pointer1 += 1;
                maxLength = Math.max(length1, maxLength);
                posList1.add(i);
            }

            if(answerKey.charAt(i) == 'F'){
                length2 += 1;
                maxLength = Math.max(length2, maxLength);
            }
            else if(record2 < k){
                record2 += 1;
                length2 += 1;
                maxLength = Math.max(length2, maxLength);
                posList2.add(i);
            }else{
                length2 = i - posList2.get(pointer2);
                pointer2 += 1;
                maxLength = Math.max(length2, maxLength);
                posList2.add(i);
            }
        }
        return maxLength;
    }
}
