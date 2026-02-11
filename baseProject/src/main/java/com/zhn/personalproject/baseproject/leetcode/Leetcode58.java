package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode58 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int maxLength = Math.max(a.length(), b.length());
        int x = 0, y = 0, res = 0;
        for(int i = 0;i < maxLength; ++i){
            if(i < a.length()){
                x = a.charAt((a.length() - 1 - i)) - '0';
            }else{
                x = 0;
            }
            if(i < b.length()){
                y = b.charAt((b.length() - 1 - i)) - '0';
            }else{
                y = 0;
            }
            sb.append((x + y + res) % 2);
            res = (x + y + res) / 2;
        }
        if(res != 0) {
            sb.append(res);
        }
        return sb.reverse().toString();
    }
}
