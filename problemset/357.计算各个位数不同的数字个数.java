/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1;i<=n;i++) {
            int c = 9;
            int more = 9;
            for(int j = 1;j<i;j++) {
                c = c*more;
                more --;
            }
            dp[i] = dp[i-1] + c;
        }
        return dp[n];
    }
}
// @lc code=end

