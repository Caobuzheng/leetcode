// https://leetcode-cn.com/contest/weekly-contest-159/problems/check-if-it-is-a-straight-line/
/**
    2 <= coordinates.length <= 1000
    coordinates[i].length == 2
    -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
    coordinates 中不含重复的点
 */
/*
 * @lc app=leetcode.cn id=1232 lang=java
 *
 * [1232] 
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        return  CheckStraightLine.checkStraightLine(coordinates);       
    }
}
class CheckStraightLine {
    public static boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<=2) return true;
        int a = coordinates[0][0];
        int b = coordinates[0][1];
        int c = coordinates[1][0];
        int d = coordinates[1][1];
        for(int i = 2; i<coordinates.length; i++) {
            if((coordinates[i][1]-b) * (c-a) != (d-b) * (coordinates[i][0]-a)){
                    return false;
            }
        }
        return true;
    }
}
// @lc code=end