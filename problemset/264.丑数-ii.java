import java.util.*;
/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    // 这个题还真的是动态规划。三个指针就行了的。
    // 然后其他的臭数也可以这么处理的
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (min == dp[i2] * 2) i2++;
            if (min == dp[i3] * 3) i3++;
            if (min == dp[i5] * 5) i5++;
            dp[i] = min;
        }

        return dp[n - 1];
    }
}
class Solution264 {
    // aha
    public static int nthUglyNumber(int n) {
        if(n==1) return 1;
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        int count = 0;
        while(true) {
            Long ugly = queue.poll();
            if(set.contains(ugly) || ugly<0 ) continue;
            set.add(ugly);
            count++;
            if(count == n) {
                return ugly.intValue();
            }
            queue.add(ugly*2);
            queue.add(ugly*3);
            queue.add(ugly*5);
        }
    }
}
// @lc code=end

