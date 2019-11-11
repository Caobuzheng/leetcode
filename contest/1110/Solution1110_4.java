/**
 * Solution1110_4
 */

import java.util.*;
public class Solution1110_4 {

    public static void main(String[] args) {
        String[] words = {"dog","cat","dad","good"};
        char[] letters = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(maxScoreWords(words, letters, score));
    }
    static int ans = 0;
    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        ans = 0;
        int[] count = new int[26];
        for(char c: letters) {
            count[c-'a'] ++;
        }
        tt(words, 0, count, score, 0);
        return ans;
    }

    private static void tt(String[] words, int index, int[] count, int[] score , int s){
        // 这里错了的。
        for(int i : count) if(i<0) return;
        ans = Math.max(ans, s);
        if(index >= words.length) return;
        String str = words[index];
        int tmp = 0;
        for(char c:str.toCharArray()) {
            int i = c-'a';
            count[i] --;
            tmp+=score[i];
        }
        // 11, 12.
        // dad good s = 11 
        tt(words, index+1, count, score, s+tmp);
        // 回溯下的
        for(char c:str.toCharArray()) {
            int i = c-'a';
            count[i] ++;
        }
        tt(words, index+1, count, score, s);

    }
}