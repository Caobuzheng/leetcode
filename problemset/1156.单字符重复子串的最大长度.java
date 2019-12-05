/*
 * @lc app=leetcode.cn id=1156 lang=java
 *
 * [1156] 单字符重复子串的最大长度
 */

// @lc code=start
class Solution {
    public int maxRepOpt1(String text) {
        return So1156.maxRepOpt1(text);
    }
}
class So1156 {

    public static void main(String[] args) {
        System.out.println(maxRepOpt1("ababa")); // 3
        System.out.println(maxRepOpt1("aaabaaa"));// 6 
        System.out.println(maxRepOpt1("aaabbaaa"));// 4
        System.out.println(maxRepOpt1("aaaaaaa"));// 5
        System.out.println(maxRepOpt1("abcdef"));// 1
    }

    public static int maxRepOpt1(String text) {
        int[] total = new int[26];
        char[] chars = text.toCharArray();
        for(char c: chars) {
            total[c-'a']++;
        }
        int index = 0;
        int next = 1;
        int count = 1;
        boolean fake = false;
        int max = 0;
        char c = chars[0];
        while(index<chars.length-1) {
           if(c != chars[index+1]) {
               if(fake){
                    max = Math.max(max, Math.min(count, total[c-'a']));           
                    index = next;
                    count = 1;
                    c = chars[index];
                    fake = false;
               }else {
                    fake = true;
                    next = index+1;
                    count++;
                    index++;
               }
           }else {
               count++;
               index++;
           }
        }
        max = Math.max(max, Math.min(count, total[c-'a']));
        return max;
    }
}
// @lc code=end

