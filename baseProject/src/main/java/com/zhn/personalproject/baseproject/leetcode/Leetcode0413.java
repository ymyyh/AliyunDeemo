package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode0413 {
    public String smallestPalindrome(String s, int k) {
        int[] record = new int[26];
        for(int i = 0;i < s.length(); ++i){
            record[s.charAt(i) - 'a']++;
        }
        char recordChar = 'a';
        for(int i = 0;i < 26; ++i){
            if(record[i] % 2 == 1){
                recordChar = (char)(i + 'a');
            }
            record[i] = (record[i]) / 2;
        }
        StringBuilder sb = new StringBuilder();
        int length = (s.length()) / 2;

        long totalCount = countValue(length);
        for(int m = 0;m < 26; ++m){
            if(record[m] > 0) {
                totalCount /= countValue(record[m]);
            }
        }

        if(k > totalCount){
            return "";
        }


        for(int i = 0;i < length; ++i){
            for(int j = 0;j < 26; ++j){
                if(record[j] <= 0){
                    continue;
                }
                record[j]--;
                long count = countValue(length - i - 1);
                for(int m = 0;m < 26; ++m){
                    if(record[m] > 0) {
                        count /= countValue(record[m]);
                    }
                }

                if(count >= k){
                    sb.append((char)(j + 'a'));
                    break;
                }else{
                    record[j]++;
                    k -= count;
                }
            }
        }
        String copyString;
        copyString = sb.toString();
        if(s.length() % 2 == 1){
            sb.append(recordChar);
        }
        for(int i = copyString.length() - 1;i >= 0; --i){
            sb.append(copyString.charAt(i));
        }
        return sb.toString();
    }

    public long countValue(int n){
        long sum = 1;
        for(int i = 1;i <= n; ++i){
            sum = sum * i;
        }
        return sum;
    }
}
