/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        if(s.contains("AA")) return false;
        return (s.split("A").length <=2 && !s.contains("LLL"));
    }
}
// @lc code=end

