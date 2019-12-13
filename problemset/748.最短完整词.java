import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=748 lang=java
 *
 * [748] 最短完整词
 */

// @lc code=start
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] tags = new int[26];
        for(char c: licensePlate.toLowerCase().toCharArray()) {
            if(c>='a' && c<='z') {
                tags[c-'a']++;
            }
        }
        Arrays.sort(words,(s1, s2)->s1.length() - s2.length());

        for(String str: words){
            int[] strTag = new int[26];
            for(char c: str.toLowerCase().toCharArray()) {
                if(c>='a' && c<='z') {
                    strTag[c-'a']++;
                }
            }   
            boolean find = true;
            for(int i =0;i<26 && find;i++) {
                if(tags[i]  > strTag[i]) find = false;
            }
            if(find) return str;
        }
        return "";
    }
}
// @lc code=end

