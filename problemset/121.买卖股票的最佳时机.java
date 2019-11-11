/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        return Solution121.maxProfit(prices);
    }
}
class Solution121 {
    public static int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int max = prices[prices.length-1];
        int ans = 0;
        for(int i = prices.length-2;i>=0;i--) {
            if(prices[i]>max) {
                max = prices[i];
            }else {
                ans = Math.max(max - prices[i], ans);
            }
        }
        return ans;
    }
}
// @lc code=end

