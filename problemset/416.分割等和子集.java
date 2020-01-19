import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.*;

/*
 * Accepted
 * 105/105 cases passed (44 ms)
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 *
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/description/
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        return Solution416.canPartition(nums);
    }
}
class Solution416 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[] {1,2,5}));
        System.out.println(canPartition(new int[] {1,5,11,5}));
        System.out.println(canPartition(new int[] {1,2,3,5}));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(sum%2 != 0) return false;
        int target = sum/2;
        boolean[] dp = new boolean[sum+1];
        // 用个dp也是可以的啦。
        dp[0] = true;
        for(int num: nums) {
            for(int i=target; i>=num; i--){
                dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[target];
    }
}
// @lc code=end

