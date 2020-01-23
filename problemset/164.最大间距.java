/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        return S164.maximumGap(nums);
    }
}
class S164{
    public static int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        int max = 0;
        // 排序的不让用了啊啊啊。
        // 还有什么办法的么
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for(int i: nums) {
            minVal = Math.min(minVal, i);
            maxVal = Math.max(maxVal, i);
        }
        // [3,6,9,1]
        // 这个玩意不还是排序的么？
        // 然后就是线段切分的了。

        return max;
    }
}
// @lc code=end

