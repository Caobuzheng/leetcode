/*
 * @lc app=leetcode.cn id=1131 lang=java
 *
 * [1131] 绝对值表达式的最大值
 */

// @lc code=start
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        // 这个好难的了。
        int max = 0;
        
        int[] arr3 = new int[arr1.length];
        for(int i = 0; i< arr1.length; i++) {
            arr3[i] = Math.abs(arr1[i] - arr2[i]);
        }
        // 那么这个题就是有点意思了的。
        int l = 0;
        int r = arr1.length-1;
        while(l<r) {
            
        }
        return max;
    }
}
// @lc code=end

