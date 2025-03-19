package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode3305 {
    public int countOfSubstrings(String word, int k) {
        Set<Character> charSet = new HashSet<>();
        int count = 0;
        int result = 0;
        for(int i = 0;i < word.length(); ++i){
            count = 0;
            charSet.clear();
            for(int j = i;j < word.length(); ++j){
                if(word.charAt(j) == 'a'){
                    count += 1;
                    charSet.add(word.charAt(j));
                }else if(word.charAt(j) == 'e'){
                    count += 1;
                    charSet.add(word.charAt(j));
                }else if(word.charAt(j) == 'i'){
                    count += 1;
                    charSet.add(word.charAt(j));
                }else if(word.charAt(j) == 'o'){
                    count += 1;
                    charSet.add(word.charAt(j));
                }else if(word.charAt(j) == 'u'){
                    count += 1;
                    charSet.add(word.charAt(j));
                }


                if(charSet.size() == 5 && j - i + 1 - count == k){
                    result += 1;
                }else if(charSet.size() == 5 && j - i + 1 - count > k){
                    break;
                }
            }
        }
        return result;
    }
}
