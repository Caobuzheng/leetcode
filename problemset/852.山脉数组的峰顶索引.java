/*
 * @lc app=leetcode.cn id=852 lang=java
 *
 * [852] 山脉数组的峰顶索引
 */

// @lc code=start
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int[] rightView = new int[A.length];

        int max = -1;
        rightView[A.length -1] = -1;
        for(int i= A.length -1;i>=0;i--) {
            rightView[i] = max;
            max = Math.max(A[i], max);
        }
        int lMax = A[0];
        for(int i = 1;i<A.length-1;i++) {
            if(A[i] > lMax && A[i] > rightView[i]) return i;
            lMax = Math.max(A[i], lMax);
        }
        return -1;
    }
}
// @lc code=end

