package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode1328 {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() <= 1){
            return "";
        }

        StringBuilder sb = new StringBuilder(palindrome);
        int pointer = 0;
        while(pointer < palindrome.length()){
            if(sb.charAt(pointer) != 'a' && (palindrome.length() % 2 == 0 || (palindrome.length() % 2 == 1 && pointer != (palindrome.length() -1) / 2))){
                sb.setCharAt(pointer, 'a');
                break;
            }
            pointer += 1;
        }

        if(pointer >= palindrome.length()){
            sb.setCharAt(sb.length() - 1, 'b');
            return sb.toString();
        }
        return sb.toString();
    }
}
