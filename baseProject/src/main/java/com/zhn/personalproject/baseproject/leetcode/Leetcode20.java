package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leetcode20 {
    public boolean isValid(String s) {
        Map<Character, Character> record = Map.of(
                '(', ')',
                '[', ']',
                '{', '}',
                ')', '(',
                ']', '[',
                '}', '{'
        );
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length(); ++i){
            if(stack.isEmpty() || !(stack.peek() == record.get(s.charAt(i)))){
                stack.push(s.charAt(i));
            }else{
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
