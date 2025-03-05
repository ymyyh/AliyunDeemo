package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1472 {
    int pointer = 0;
    int limit = 1;
    List<String> browserHistory = new ArrayList<>();
    public Leetcode1472(String homepage) {
        browserHistory = new ArrayList<>();
        browserHistory.add(homepage);
        pointer = 0;
        limit = 1;
    }

    public void visit(String url) {
        pointer += 1;
        if(pointer >= browserHistory.size()){
            browserHistory.add(url);
            limit = pointer + 1;
        }else{
            browserHistory.set(pointer, url);
            limit = pointer + 1;
        }
    }

    public String back(int steps) {
        if(pointer - steps >= 0){
            pointer -= steps;
            return browserHistory.get(pointer);
        }else{
            pointer = 0;
            return browserHistory.get(0);
        }
    }

    public String forward(int steps) {
        if(pointer + steps < limit){
            pointer += steps;
            return browserHistory.get(pointer);
        }else{
            pointer = limit - 1;
            return browserHistory.get(limit - 1);
        }
    }
}
