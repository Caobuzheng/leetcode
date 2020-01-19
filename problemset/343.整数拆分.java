/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    int[] dp;
    public int integerBreak(int n) {
        dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 0;        
        return max(n);
    }

    int max(int n) {
        if(dp[n] != 0) return dp[n];
        int max = 0;
        for(int i = 1; i<n;i++) {
            max = Math.max(Math.max(max(i), i) * Math.max(max(n-i), n-i), max);
        }
        return dp[n] = max;
    }
}
// @lc code=end

