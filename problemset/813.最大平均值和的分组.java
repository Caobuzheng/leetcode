/*
 * @lc app=leetcode.cn id=813 lang=java
 *
 * [813] 最大平均值和的分组
 */

// @lc code=start
class Solution {
    double[][] dp;
    public double largestSumOfAverages(int[] A, int K) {
        dp = new double[A.length][K+1];
        int sum = 0;
        int length = 0;
        for(int i = A.length-1;i>=0;i--) {
            sum+=A[i];
            length++;
            dp[i][1] = (double) sum/length;
        }
        return help(A, 0, K);
    }
    double help(int[] a, int j,int k) {
        if(j>=a.length || k<=0) {
            return 0;
        }
        if(dp[j][k] != 0) return dp[j][k];
        int sum = 0;
        int length = 0;
        double max = 0;
        for(int i = j;i<=a.length-k;i++) {
            sum += a[i];
            length++;
            max = Math.max(max, (double)sum/length + help(a, i+1, k-1));
        }
        return dp[j][k] = max;
    }
}
// @lc code=end

