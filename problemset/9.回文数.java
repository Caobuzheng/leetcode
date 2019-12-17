/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        char[] chars = ("" + x).toCharArray();
        int l = 0;
        int r = chars.length-1;
        while(l<r) {
            if(chars[l++] != chars[r--]) return false;
        }        
        return true;
    }
}
// @lc code=end

