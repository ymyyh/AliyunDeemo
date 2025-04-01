package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode2109 {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int record = 0;
        for(int space : spaces){
            sb.insert(space+record," ");
            record++;
        }
        return sb.toString();
    }
}
