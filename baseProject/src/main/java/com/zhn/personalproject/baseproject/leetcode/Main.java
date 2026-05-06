package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Leetcode1861 leetcode = new Leetcode1861();
        System.out.println(leetcode.rotateTheBox(new char[][]{{'#','#','*','.','*','.'},{'#','#','#','*','.','.'},{'#','#','#','.','#','.'}}));
    }
}
