/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */
import java.util.*;

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        // 没用变量。但是啊。那个get的操作，感觉会比较耗时。
        for(int i = 1; i<triangle.size();i++) {
            List<Integer> now = triangle.get(i);
            List<Integer> last = triangle.get(i-1);
            now.set(0, now.get(0) + last.get(0));
            now.set(now.size()-1, now.get(now.size()-1) + last.get(now.size()-2));
            for(int j = 1;j<now.size()-1;j++) {
                now.set(j, now.get(j) + Math.min(last.get(j),last.get(j-1)));
            }
        }
        for(int val:triangle.get(triangle.size()-1)) {
            min = Math.min(min, val);
        }
        return min;
    }
}
// @lc code=end

