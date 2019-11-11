/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 买之前必须是00才行的。
        // 
        return Solution309.maxProfit(prices);
    }
}
class Solution309 {
    public static int maxProfit(int[] prices) {
        // how to
        if(prices.length <= 1) return 0;
        int[] dp = new int[prices.length+1];
        dp[0] = 0;
        dp[1] = prices[1] - prices[0];
        dp[2] = 
    }
}
// @lc code=end

