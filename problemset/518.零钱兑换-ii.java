/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */
import java.util.*;
// @lc code=start
class Solution {
    // 牛逼答案
    // 思考下，这个有点像那个公交车的。不过我很难想到这个思路。
    // 我的答案应该算是mem，而不是dp的了。不行，这个简直是太绕了。
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins) {
            for(int i = coin; i < amount+1; ++i) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}

// 我的答案。
class Solution518 {
    public static void main(String[] args) {
        System.out.println(change(3, new int[]{2}));
    }

    static int[][] mem;
    public static int change(int amount, int[] coins) {
        if(amount ==0) return 1;
        if(coins.length ==0 || amount == 0) return 0;
        mem = new int[coins.length][amount+1];
        for(int[] memm: mem) {
            Arrays.fill(memm, -1);
        }
        dfs(amount, coins, 0);
        int ans = mem[0][amount];
        return  ans == -1? 0: ans;
    }

    static int  dfs(int amount, int[] coins, int index) {
        if(amount==0) return 1;
        if(index>=coins.length || amount<0)  return 0;
        if(mem[index][amount] != -1) return mem[index][amount];
        int val = coins[index];
        int count = 0;
        for(int i = 0; i<=amount/val;i++) {
          count+=dfs(amount-i*val,coins,index+1);
        }
        mem[index][amount] = count;
        return count;
    }
}
// @lc code=end

