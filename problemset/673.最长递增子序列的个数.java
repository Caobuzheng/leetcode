/*
 * @lc app=leetcode.cn id=673 lang=java
 *
 * [673] 最长递增子序列的个数
 */

// @lc code=start
class Solution {
    public int findNumberOfLIS(int[] nums) {
        return Solution673.findNumberOfLIS(nums);
    }
}
class Solution673 {
    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1,3,5,4,7}));
        System.out.println(findNumberOfLIS(new int[]{2,2,2,2,2}));
    }
    public static int findNumberOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        dp[0] = 1;
        count[0] = 1;
        for(int i = 1;i < nums.length;i++) {
            int max = 0;
            int sum = 0;
            for(int j=i-1;j>=0;j--){
                if(nums[i] > nums[j]) {
                    if(dp[j] > max) {
                        max = dp[j];
                        sum=count[j];
                    }else if(dp[j] == max) {
                        sum+=count[j];
                    }
                }
            }
            dp[i] = max+1;
            count[i] = Math.max(sum, 1);
        }
        int max = 0;
        int sum= 0;
        for(int i = 0; i< nums.length;i++) {
            if(dp[i] > max) {
                max = dp[i];
                sum = count[i];
            }else if(dp[i] == max){
                sum+=count[i];
            }
        }
        return sum;
    }
}
// @lc code=end

