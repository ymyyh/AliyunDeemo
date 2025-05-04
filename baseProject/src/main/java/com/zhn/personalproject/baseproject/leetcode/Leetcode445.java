package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode445 {
    public String smallestPalindrome(String s) {
        int[] record = new int[27];
        List<Character> list = new ArrayList<>();
        for(int i = 0;i < s.length();i++){
            record[s.charAt(i) - 'a']++;
        }
        char pp = 'a';
        for (int i = 0; i < record.length; i++) {
            if(record[i] % 2 == 0){
                for(int j = 0;j < record[i];j++){
                    list.add((char) (i + 'a'));
                }
            }else{
                for(int j = 0;j < record[i] - 1;j++){
                    list.add((char) (i + 'a'));
                }
                pp = (char) (i + 'a');
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(char c : list){
            sb.insert(sb.length() / 2, c);
        }
        if(s.length() % 2 != 0){
            sb.insert(sb.length() / 2, pp);
        }
        return sb.toString();
    }
}
