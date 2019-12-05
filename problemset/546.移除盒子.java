/*
 * @lc app=leetcode.cn id=546 lang=java
 *
 * [546] 移除盒子
 */

// @lc code=start
class Solution {
    /**
     * [1, 3, 2, 2, 2, 3, 4, 3, 1] 
----> [1, 3, 3, 4, 3, 1] (3*3=9 分) 
----> [1, 3, 3, 3, 1] (1*1=1 分) 
----> [1, 1] (3*3=9 分) 
----> [] (2*2=4 分)
     * @param boxes
     * @return
     */
    public int removeBoxes(int[] boxes) {
        // 100个，那么全部的枚举肯定是ttl的了。
        // 肯定有贪心在里头的！还有dp的状态转移。不过这都是我的猜测。
        // 这个题，我之前肯定是见过的。
        // 贪心算法？
        return So546.removeBoxes(boxes);
    }
}
class So546 {
    public static int removeBoxes(int[] boxes) {
        int ans = 0;
        // 如果，我怎么
        // 好像就是全部枚举。没啥太好的办法。
        return ans;
    }
}
// @lc code=end

