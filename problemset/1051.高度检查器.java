import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1051 lang=java
 *
 * [1051] 高度检查器
 */

// @lc code=start
class Solution {
    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int ans = 0;
        for(int i = 0; i< copy.length;i++) {
            if(copy[i] != heights[i]) ans++;
        }
        return ans;
    }
}
// @lc code=end

