package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode033003 {
    int maxLength = 0;
    public int longestPalindrome(String s, String t) {
        String totalString = s+t;
        int cut = s.length();
        for(int i=0;i<totalString.length();i++){
            dfs(1, totalString, i - 1, i + 1, 1, cut);
            dfs(1, totalString, i, i + 1, 0, cut);
        }
        return maxLength;
    }

    public void dfs(int count, String str, int pointer1, int pointer2, int length, int cut) {
        if(pointer1 < 0 || pointer2 >= str.length()){
            maxLength = Math.max(maxLength, length);
            return;
        }

        if(str.charAt(pointer1) == str.charAt(pointer2)){
            dfs(count, str, pointer1-1, pointer2+1, length+2, cut);
        }else if(count != 0){
            if(pointer1 >= cut - 1) {
                int newPointer1 = cut - 1;
                while(newPointer1 >= 0) {
                    while (newPointer1 >= 0 && str.charAt(newPointer1) != str.charAt(pointer2)) {
                        newPointer1--;
                    }

                    if (newPointer1 >= 0 && str.charAt(newPointer1) == str.charAt(pointer2)) {
                        dfs(0, str, newPointer1 - 1, pointer2 + 1, length + 2, cut);
                    }
                    if(newPointer1 >= 0){
                        newPointer1--;
                    }
                }
            }

            if(pointer2 < cut + 1) {
                int newPointer2 = cut;
                while (newPointer2 < str.length()) {
                    while (newPointer2 < str.length() && str.charAt(newPointer2) != str.charAt(pointer1)) {
                        newPointer2++;
                    }
                    if (newPointer2 < str.length() && str.charAt(newPointer2) == str.charAt(pointer1)) {
                        dfs(0, str, pointer1 - 1, newPointer2 + 1, length + 2, cut);
                    }
                    if(newPointer2 < str.length()){
                        newPointer2++;
                    }
                }
            }
        }
        maxLength = Math.max(maxLength, length);
    }
}
