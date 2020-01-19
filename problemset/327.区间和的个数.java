/*
 * @lc app=leetcode.cn id=327 lang=java
 *
 * [327] 区间和的个数
 */

// @lc code=start
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        return badN2(nums, lower, upper);
    }

    public int badN2(int[] nums, int lower, int upper) {
        long more = 0L;
        long[] xx = new long[nums.length+1];
        for(int i = 0;i<nums.length;i++) {
            xx[i+1] += more;
            more+=nums[i];
        }
        xx[nums.length] = more;
        int ans = 0;
        for(int i = 1;i<=nums.length;i++) {
            for(int j = i;j<=nums.length;j++) {
                long val = xx[j] - xx[i-1];
                if(val >= lower && val <=upper) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

