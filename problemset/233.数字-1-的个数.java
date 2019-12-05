/*
 * @lc app=leetcode.cn id=233 lang=java
 *
 * [233] 数字 1 的个数
 */

// @lc code=start
class Solution {
    public int countDigitOne(int n) {
        return So233.countDigitOne(n);
    }
}
class So233 {
    // 1, 10, 11, 12, 13 return 6
    public static int countDigitOne(int n) {
        int count = 0;

        // 9 99 999 999
        // 199 = 140。。。ok
        int[] ts = {
            1,20,300,4000,
        };
        // 为啥100 -> 190. 199->140 
        return count;
    }
}
// @lc code=end

