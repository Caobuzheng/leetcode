/*
 * @lc app=leetcode.cn id=650 lang=java
 *
 * [650] 只有两个键的键盘
 */

// @lc code=start
class Solution {
    public static int minSteps(int n) {
        return Solution650.minSteps(n);
    }
    // 10\n100\n1000
}
class Solution650 {
    public static void main(String[] args) {
        System.out.println(minSteps(1000));
    }
    public static int minSteps(int n) {
        if(n<=1) return 0;
        if(n<=3) return n;
        int[] dp = new int[n+1];
        for(int i = 0; i<=n; i++) dp[i] = i;
        for(int i = 2;i<=n;i++) {
            int count = 2;
            int index = i*count++;
            // 这个不是很大，直接这么暴力的搞吧。
            while(index<=n) {
                dp[index] = Math.min(dp[index], dp[i] + count - 1);
                index = i*count++;
            }
        }
        return dp[n];
    }
}
// @lc code=end

