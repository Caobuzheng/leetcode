/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 *
 * https://leetcode-cn.com/problems/dungeon-game/description/
 *
 * algorithms
 * Hard (38.05%)
 * Likes:    124
 * Dislikes: 0
 * Total Accepted:    4.6K
 * Total Submissions: 12.1K
 * Testcase Example:  '[[-2,-3,3],[-5,-10,1],[10,30,-5]]'
 * res = 7
 *
 * 
 * 说明:
 * 骑士的健康点数没有上限。
 * 
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 * 
 */

// @lc code=start
class Solution {
    // this is a good question
    public int calculateMinimumHP(int[][] dungeon) {
        return CalculateMinimumHP.calculateMinimumHP(dungeon);
    }
}
class CalculateMinimumHP {
    public static void main(String[] args) {
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(calculateMinimumHP(dungeon));
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        if(m == 0) return 0;
        int n = dungeon[0].length;
        if(n == 0) return 0;
        int min = Integer.MAX_VALUE;
        for(int i = n-1;i>=0;i--) {
            if(i<0) {
                // 这个可以把前面的那个变成0。
            } 
        }
        for(int i = n-1;i>=0;i--) {
            // 先处理下最后一行的哈
        }

        // init it?
       
        
        // how to dp it?
        // this one is hard??? unbelievable
        return min;
    } 
}
// @lc code=end

