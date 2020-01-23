/*
 * @lc app=leetcode.cn id=214 lang=java
 *
 * [214] 最短回文串
 */

// @lc code=start
class Solution {
    public String shortestPalindrome(String s) {
        return Solution214.shortestPalindrome(s);
    }
}
class Solution214 {
    public static String shortestPalindrome(String s) {
        char[] chars = s.toCharArray();
        for(int i = chars.length-1;i>=0;i--) {
            if(isPal(chars, 0, i)){
                StringBuilder sb = new StringBuilder();
                for(int j = i+1;j<chars.length;j++) {
                    sb.append(chars[j]);
                }
                return sb.reverse().toString() + s;
            }
        }
        return s;
    }
    
    static boolean isPal(char[] chars, int l, int r) {
        while(l<r) {
            if(chars[l++] != chars[r--]) return false;
        }
        return true;
    }
}
// @lc code=end

