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
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length]; 
        if(prices.length <= 1) return 0;
        dp[0] = 0;
        for(int i = 1; i< prices.length; i++) {
            int lastMin = prices[i-1];
            int tmpMax = 0;
            for(int j = i-1; j>=0; j--){
                lastMin = Math.min(lastMin, prices[j]);
                if(j>=3) {
                    tmpMax = Math.max(prices[i] - lastMin + dp[j-2], tmpMax);
                }else {
                    tmpMax = Math.max(prices[i] - lastMin, tmpMax);
                }
            }
            dp[i] = tmpMax;
        }
        int max = 0;
        for(int i :dp) {
            max = Math.max(max, i);
        }
        return max;
    }
}
// @lc code=end

