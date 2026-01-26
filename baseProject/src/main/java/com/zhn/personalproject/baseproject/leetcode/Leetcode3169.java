package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Leetcode3169 {
    public boolean isValid(String word) {
        if(word.length() < 3){
            return false;
        }
        Character[] chars = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> characterSet = Arrays.stream(chars).collect(Collectors.toSet());
        int tag1 = 0;
        int tag2 = 0;
        for(int i = 0;i < word.length(); ++i){
            if(!(((word.charAt(i) - 'a') >=0 && (word.charAt(i) - 'a') <= 25) || (word.charAt(i) - 'A' >= 0 && (word.charAt(i) - 'A') <= 25)
               || (word.charAt(i) - '0' >= 0 && (word.charAt(i) - '0') <= 9))){
                return false;
            }

            if(characterSet.contains(word.charAt(i))){
                tag1 = 1;
            }else if((((word.charAt(i) - 'a') >=0 && (word.charAt(i) - 'a') <= 25) || (word.charAt(i) - 'A' >= 0 && (word.charAt(i) - 'A') <= 25)) && !characterSet.contains(word.charAt(i))){
                tag2 = 1;
            }
        }

        return tag1 == 1 && tag2 == 1;
    }
}
