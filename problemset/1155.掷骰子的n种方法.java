/*
 * @lc app=leetcode.cn id=1155 lang=java
 *
 * [1155] 掷骰子的N种方法
 */

// @lc code=start
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        return So1155.numRollsToTarget(d, f, target);
    }
}
class So1155 {
    public static void main(String[] args) {
        System.out.println(numRollsToTarget(30, 30, 500)); // 222616187
    }
    public static int numRollsToTarget(int d, int f, int target) {
        if (target < d || target > d * f) {
            return 0;
        }  

 
        int[][] dp = new int[31][1001];
        int mod = 1000000007;
        for(int i = 1;i<=f;i++) {
            dp[1][i] = 1;
        }
        for(int i = 2;i<=d;i++) {
            // 错了。老子不够使用了的
            for(int j = 1; j<=f;j++) {
                for(int k = i; k<=target && k+j <=target; k++) {
                    dp[i][k+j] = (dp[i][k+j]+ dp[i-1][j]) % mod;
                }
            }
        }
        return dp[d][target];
 
    }
}
// @lc code=end

