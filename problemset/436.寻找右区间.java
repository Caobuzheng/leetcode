/*
 * @lc app=leetcode.cn id=436 lang=java
 *
 * [436] 寻找右区间
 */

// @lc code=start
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        // On2的写完了。
        if(intervals.length == 0) return null;
        int[] ans = new int[intervals.length];
        for(int i = 0;i < intervals.length;i++) {
            int index = -1;
            int tmp = Integer.MAX_VALUE;
            for(int j = 0;j<intervals.length;j++) {
                if(i==j) continue;
                if(intervals[j][0] >= intervals[i][1]) {
                    if(tmp>intervals[j][0]) {
                        index = j;
                        tmp = intervals[j][0];
                    }
                }
            }
            ans[i] = index;
        }
        return ans;
    }
}
// @lc code=end

