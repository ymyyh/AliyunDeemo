package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode033002 {
    public int longestPalindrome(String s, String t) {
        int maxLength = 0;
        for(int i = 0;i < s.length(); ++i){
            for(int j = s.length(); j >= i; --j){
                for(int m = 0;m < t.length(); ++m){
                    for(int n = t.length(); n >= m; --n){
                        String temp = s.substring(i,j) + t.substring(m,n);
                        if(testStr(temp)){
                            maxLength = Math.max(maxLength, temp.length());
                        }
                    }
                }
            }
        }
        return maxLength;
    }

    public boolean testStr(String str){
        int pointer1 = 0;
        int pointer2 = str.length() - 1;

        while(pointer1 < pointer2){
            if(str.charAt(pointer1) != str.charAt(pointer2)){
                return false;
            }
            pointer1++;
            pointer2--;
        }
        return true;
    }
}
