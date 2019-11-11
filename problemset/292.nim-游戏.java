/*
 * @lc app=leetcode.cn id=292 lang=java
 *
 * [292] Nim 游戏
 */

// @lc code=start
class Solution {
    public boolean canWinNim(int n) {
        return Solution292.canWinNim(n);
    }
}
class Solution292 {
    public static boolean canWinNim(int n) {
        if(n%4 == 0) return false;
        return true;
    }
}
// @lc code=end

