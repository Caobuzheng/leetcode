/*
 * @lc app=leetcode.cn id=1053 lang=java
 *
 * [1053] 交换一次的先前排列
 */

// @lc code=start
class Solution {
    public int[] prevPermOpt1(int[] A) {
        // 这个感觉还好的呀。
        int n = A.length;
        boolean find = false;
        int max = A[0];
        int i=1;
        for(;i<n;i++) {
            if(A[i] < max) {
                find = true;
            }else {
                max = A[i];
            }
        }
        if(!find) return A;
        int min = max;
        int minIndex = i;
        for(int j = i+1;j<n;j++) {

        }
    }
}
// @lc code=end

