/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        dp[1] = Math.max(prices[1] - prices[0], 0);
        for(int i = 2;i<prices.length;i++) {
            if(prices[i]>prices[i-1]) {
                dp[i] = dp[i-1] + prices[i] - prices[i-1];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[prices.length-1];
    }
}

// @lc code=end

