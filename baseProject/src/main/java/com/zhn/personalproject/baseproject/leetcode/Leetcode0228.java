package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode0228 {
    public int concatenatedBinary(int n) {
        long res = (long) (1000000007L);
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i <= n; ++i){
            sb.append(Integer.toBinaryString(i));
            long num = (Long.parseLong(sb.toString(), 2) % res);
            sb = new StringBuilder(Long.toBinaryString(num));
        }

        return Integer.parseInt(sb.toString(), 2);
    }

}
