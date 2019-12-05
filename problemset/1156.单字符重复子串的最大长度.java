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
    static int[] last;
    static char[] chars;
    static int max;
    public static int maxRepOpt1(String text) {
        last = new int[26];
        chars = text.toCharArray();
        max = 0;
        for(int i = 0; i<chars.length; i++) {
            last[chars[i] - 'a'] = i;
        }
        int i = 1;
        int next = 1;
        int count = 1;
        for(;i<text.length();i++) {
            // 这块就有点意思了的
            if()
        }
    }
}
// @lc code=end

