package com.zhn.personalproject.baseproject.leetcode;


import java.util.HashMap;
import java.util.Map;

public class Leetcode3714 {
    public int longestBalanced(String s) {

        int totalA = 0, totalB = 0, totalC = 0;
        for(int i = 0;i < s.length(); ++i){
            if(s.charAt(i) == 'a'){
                totalA += 1;
            }else if(s.charAt(i) == 'b'){
                totalB += 1;
            }else{
                totalC += 1;
            }
        }

        if(totalA == totalB && totalB == totalC){
            return s.length();
        }



        int result = 0;

        int count1A = 0;
        int count1B = 0;
        int count1C = 0;

        int count2A1 = 0, count2B1 = 0;
        int count2B2 = 0, count2C2 = 0;
        int count2A3 = 0, count2C3 = 0;

        Map<Integer, Integer> recordABMap = new HashMap<>();
        Map<Integer, Integer> recordBCMap = new HashMap<>();
        Map<Integer, Integer> recordACMap = new HashMap<>();

        int count3A = 0;
        int count3B = 0;
        int count3C = 0;
        Map<String, Integer> recordMap = new HashMap<>();
        recordMap.put("0_0_0", -1);
        recordABMap.put(0, -1);
        recordBCMap.put(0, -1);
        recordACMap.put(0, -1);
        for(int i = 0;i < s.length(); ++i){
            if(s.charAt(i) == 'a'){
                count1B = 0;
                count1C = 0;
                count1A += 1;
                result = Math.max(result, count1A);

                count2A1 += 1;
                if(recordABMap.containsKey(count2A1 - count2B1)){
                    result = Math.max(result, i - recordABMap.get(count2A1 - count2B1));
                }else{
                    recordABMap.put(count2A1 - count2B1, i);
                }

                count2A3 += 1;
                if(recordACMap.containsKey(count2A3 - count2C3)){
                    result = Math.max(result, i - recordACMap.get(count2A3 - count2C3));
                }else{
                    recordACMap.put(count2A3 - count2C3, i);
                }

                count2B2 = 0;
                count2C2 = 0;
                recordBCMap.clear();
                recordBCMap.put(0, i);

                count3A += 1;
            }else if(s.charAt(i) == 'b'){
                count1A = 0;
                count1C = 0;
                count1B += 1;
                result = Math.max(result, count1B);

                count2B1 += 1;
                if(recordABMap.containsKey(count2A1 - count2B1)){
                    result = Math.max(result, i - recordABMap.get(count2A1 - count2B1));
                }else{
                    recordABMap.put(count2A1 - count2B1, i);
                }

                count2B2 += 1;
                if(recordBCMap.containsKey(count2B2 - count2C2)){
                    result = Math.max(result, i - recordBCMap.get(count2B2 - count2C2));
                }else{
                    recordBCMap.put(count2B2 - count2C2, i);
                }

                count2A3 = 0;
                count2C3 = 0;
                recordACMap.clear();
                recordACMap.put(0, i);

                count3B += 1;
            }else{
                count1A = 0;
                count1B = 0;
                count1C += 1;
                result = Math.max(result, count1C);

                count2C2 += 1;
                if(recordBCMap.containsKey(count2B2 - count2C2)){
                    result = Math.max(result, i - recordBCMap.get(count2B2 - count2C2));
                }else{
                    recordBCMap.put(count2B2 - count2C2, i);
                }

                count2C3 += 1;
                if(recordACMap.containsKey(count2A3 - count2C3)){
                    result = Math.max(result, i - recordACMap.get(count2A3 - count2C3));
                }else{
                    recordACMap.put(count2A3 - count2C3, i);
                }

                count2A1 = 0;
                count2B1 = 0;
                recordABMap.clear();
                recordABMap.put(0, i);

                count3C += 1;
            }

            int min = Math.min(count3A, Math.min(count3B, count3C));
            String key = (count3A - min) + "_" + (count3B - min) + "_" + (count3C -min);
            if(!recordMap.containsKey(key)){
                recordMap.put(key, i);
            }else{
                result = Math.max(result, i - recordMap.get(key));
            }
        }

        return  result;
    }
}
