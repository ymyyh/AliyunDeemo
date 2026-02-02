package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode29 {
    public int divide(int dividend, int divisor) {

        long dividendLong = dividend;
        long divisorLong = divisor;

        int res = 1;
        if((dividendLong > 0 && divisorLong < 0) || (dividendLong < 0 && divisorLong > 0)){
            res = -1;
        }
        if(dividendLong < 0){
            dividendLong = -dividendLong;
        }
        if(divisorLong < 0){
            divisorLong = -divisorLong;
        }

        if(dividendLong < divisorLong){
            return  0;
        }

        long temp = divisorLong;
        long record = 1;
        long result = 0;
        while(temp + temp <= dividendLong){
            temp <<= 1;
            record <<= 1;
        }

        while(record > 0){
            if(dividendLong >= temp){
                dividendLong -= temp;
                result |= record;
            }
            record >>= 1;
            temp >>= 1;
        }

        result = res > 0 ? result : -result;
        if(result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }
}
