/*
 * @lc app=leetcode.cn id=486 lang=java
 *
 * [486] 预测赢家
 */
import java.util.*;
// @lc code=start
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return Solution486.PredictTheWinner(nums);
    }
}

class Solution486 {
    public static void main(String[] args) {
        // int[] nums = {1, 5, 233, 7};
        // System.out.println(PredictTheWinner(nums));
        System.out.println(PredictTheWinner(new int[]{3606449,6,5,9,452429,7,9580316,9857582,8514433,9,6,6614512,753594,5474165,4,2697293,8,7,1}));
    }
    static Long[][] tag;
    static Long[] sums;
    public static boolean PredictTheWinner(int[] nums) {
        sums = new Long[nums.length+1];
        sums[0] = 0L;
        for(int i = 0;i<nums.length;i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        tag = new Long[nums.length][nums.length];
        for(int i = 0;i<nums.length;i++) {
            Arrays.fill(tag[i], -1L);
        }
        long max = dp(nums, 0, nums.length-1);
        
        Long sum = sums[nums.length];
        return max>=(sum-max);
    }

    static long dp(int[] nums, int l, int r) {
        if(l>r) return 0;
        if(tag[l][r] != -1) {
            return tag[l][r];
        }
        long res = 0L;
        if(l == r) {
            res = nums[l];
        }else {
            long left = nums[l];
            if(l+1<r) {
                left += sums[r+1] - sums[l+1] - dp(nums, l+1, r);
            }
            long right = nums[r];
            if(l<r-1) {
                right += sums[r] - sums[l] - dp(nums, l, r-1);
            }
            res = Math.max(left, right);
        }
        return tag[l][r] = res;
    }
}
// @lc code=end

