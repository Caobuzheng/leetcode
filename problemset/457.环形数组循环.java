/*
 * @lc app=leetcode.cn id=457 lang=java
 *
 * [457] 环形数组循环
 */

// @lc code=start
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        // 难度不大。
        int i = 0;
        while(true) {
            int val = nums[i];
            if(val == 0) return true;
        }
    }
}
// @lc code=end

