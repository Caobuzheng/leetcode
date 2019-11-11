/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        // why this is hard?
        int ans = 0;
        for(int i =nums.length -1;i>0;i--){
            long tmp = nums[i];
            tmp = tmp * 2;
            for(int j = i-1;j>=0;j--) {
                if(nums[j] > tmp){
                    ans++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

