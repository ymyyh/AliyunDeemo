package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode3306 {
    public long countOfSubstrings(String word, int k) {
        Set<Character> characterSet = Set.of('a', 'e', 'i', 'o', 'u');
        int result = 0;
        int left = 0;
        int right = -1;
        int pointer = 0;
        int count = 0;
        Map<Character, Integer> tempMap = new HashMap<>();
        while(left < word.length()){
            while(right < word.length() && count < k){
                right++;
                if(characterSet.contains(word.charAt(right))){
                    tempMap.put(word.charAt(right), tempMap.getOrDefault(word.charAt(right), 0) + 1 );
                }else{
                    count++;
                }

            }

            while(right < left){
                right++;
                if(characterSet.contains(word.charAt(right))){
                    tempMap.put(word.charAt(right), tempMap.getOrDefault(word.charAt(right), 0) + 1 );
                }else{
                    count++;
                }
            }

            pointer = right;
            while(pointer < word.length() && tempMap.size() == 5 && count == k){
                result += 1;
                pointer += 1;
                if(!characterSet.contains(word.charAt(pointer))) {
                    break;
                }
            }

            if(characterSet.contains(word.charAt(left))){
                if(tempMap.get(word.charAt(left)) == 1){
                    tempMap.remove(word.charAt(left));
                }else{
                    tempMap.put(word.charAt(left), tempMap.get(word.charAt(left)) - 1 );
                }
            }else{
                count -= 1;
            }
            left++;
        }
        return result;
    }
}
