package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode3306 {
    public long countOfSubstrings(String word, int k) {
        Set<Character> characterSet = new HashSet<>();
        characterSet.add('a');
        characterSet.add('e');
        characterSet.add('i');
        characterSet.add('o');
        characterSet.add('u');
        int count = 0;
        int result = 0;
        Set<Character> recordSet = new HashSet<>();
        for(int i = 0;i < word.length(); ++i){
            count = 0;
            recordSet.clear();
            for(int j = i;j < word.length(); ++j){
                if(characterSet.contains(word.charAt(j))){
                    recordSet.add(word.charAt(j));
                }else{
                    count += 1;
                }

                if(recordSet.size() == 5 && count == k){
                    result += 1;
                }else if(count > k){
                    break;
                }
            }
        }
        return result;
    }
}
