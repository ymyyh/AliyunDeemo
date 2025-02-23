package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode3133 {
    public long findMaximumNumber(long k, int x) {
        long record = 0;
        long initial = 0;
        int tag = 0;
        long count = 0;
        int bitCount = 0;
        int num = 1;

        int jump = (int) Math.pow(2, x - 1);

        while(count <= k){

            while(record < num){
                if(tag == 0){
                    record = record | 1;
                    record = record << (x - 1);
                    tag = 1;

                    initial = record;
                }
                else {
                    record = record << x;
                    record = record | initial;
                }
            }

            long temp = num;
            temp = temp & record;
            bitCount = Long.bitCount(temp);
            if(count + bitCount * jump <= k){
                count += bitCount * jump;
                num += jump;
            }else{
                count += bitCount;
                num++;
            }

            if(count > k){
                return num - 1;
            }
        }
        return num - 1;
    }
}
