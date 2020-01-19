/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int money_5 = 0;
        int money_10 = 0;
        for(int i: bills) {
            if(i == 5) {
                money_5 ++;
            }else if(i == 10) {
                money_5--;
                if(money_5<0) return false;
                money_10++;
            }else {
                if(money_10>0) {
                    money_10--;
                    money_5--;
                }else {
                    money_5-=3;
                }
                if(money_5<0) return false;
            }
        }
        return true;   
    }
}
// @lc code=end

