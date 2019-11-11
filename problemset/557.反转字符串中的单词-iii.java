/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        return Solution557.reverseWords(s);
    }
}
class Solution557 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int last = 0;
        int i = 0;
        for(; i<chars.length; i++) {
            if(chars[i] == ' ') {
                reverse(chars, last, i-1);
                last = i+1;
            }
        }
        reverse(chars, last, chars.length-1);
        return new String(chars);
    }
    private static void reverse(char[] chars, int l , int r) {
        while(l<r) {
            char tmp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = tmp;
        }
    }

}
// @lc code=end

