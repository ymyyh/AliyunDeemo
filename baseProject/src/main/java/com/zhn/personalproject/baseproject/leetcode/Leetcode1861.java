package com.zhn.personalproject.baseproject.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode1861 {
    public char[][] rotateTheBox(char[][] boxGrid) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        char[][] result = new char[boxGrid[0].length][boxGrid.length];
        for(int i = boxGrid.length - 1;i >= 0; --i){
            for(int j  = boxGrid[0].length - 1;j >= 0; --j){
                if(boxGrid[i][j] == '#'){
                    if(!pq.isEmpty()){
                        int pos = pq.poll();
                        result[pos][boxGrid.length - 1 - i] = '#';
                        result[j][boxGrid.length - 1 - i] = '.';
                        pq.offer(j);
                    }else{
                        result[j][boxGrid.length - 1 - i] = '#';
                    }
                }else if(boxGrid[i][j] == '.'){
                    pq.offer(j);
                    result[j][boxGrid.length - 1 - i] = '.';
                }else {
                    result[j][boxGrid.length - 1 - i] = boxGrid[i][j];
                    pq.clear();
                }
            }
            pq.clear();
        }

        return result;
    }
}
