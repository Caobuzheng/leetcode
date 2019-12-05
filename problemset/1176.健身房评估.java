/*
 * @lc app=leetcode.cn id=1175 lang=java
 *
 * [1175] 质数排列
 */

// @lc code=start
class Solution {
}
class Solution1176 {
    /**
     *  1 <= k <= calories.length <= 10^5
        0 <= calories[i] <= 20000
        0 <= lower <= upper
     */
    public static void main(String[] args) {
      int[] calories = {6,13,8,7,10,1,12,11};
      System.out.println(dietPlanPerformance(calories, 6, 5, 37));
      // 这个哪里来的3？
    }
    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        
        // 如果不够的话怎么算的来？
        int res = 0;
        int sum = 0;
        int tmpk = k;
        for(int i = 0; i<calories.length;) {
            sum+=calories[i];
            tmpk--;
            if(tmpk == 0) {
                if(sum<lower) res--;
                if(sum>upper) res++;
                sum = 0;
                tmpk = k;
            }
            
        }
        return res;
    }
}
// @lc code=end

