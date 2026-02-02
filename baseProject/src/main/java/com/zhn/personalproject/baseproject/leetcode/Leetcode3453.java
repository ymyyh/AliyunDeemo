package com.zhn.personalproject.baseproject.leetcode;

import java.math.BigDecimal;

public class Leetcode3453 {
    public double separateSquares(int[][] squares) {
        double max = 0;
        double min = 1e9;
        double sum = 0;
        for(int[] square : squares){
            max = Math.max(max, square[1] + square[2]);
            min = Math.min(min, square[1]);
            sum += ((double) square[2] * (double) square[2]);
        }
        double midValue = sum / 2.0;
        double midLine = (max + min) / 2.0;
        double res = checkSquare(squares, midLine, midValue);
        int count = 0;
        while((res >= 0 || res < -10e-5) && count < 100){
            if(res >= 0){
                max = midLine;
            }else{
                min = midLine;
            }
            midLine = (min + max) / 2.0;
            res = checkSquare(squares, midLine, midValue);
            count += 1;
        }

        return midLine;

    }

    public double checkSquare(int[][] squares, double line, double mid) {
        double sum = 0;
        for(int[] square : squares){
            if(square[1] > line){
                sum += square[2] * square[2];
            }else if(square[1] + square[2] > line){
                sum += ((double) (square[1] + square[2]) - line) * ((double) square[2]);
            }
        }

        return mid - sum;
    }
}
