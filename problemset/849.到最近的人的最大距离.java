/*
 * @lc app=leetcode.cn id=849 lang=java
 *
 * [849] 到最近的人的最大距离
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        int[] seats = {0,1};
        System.out.println(maxDistToClosest(seats));
    }
    public static int maxDistToClosest(int[] seats) {
        int[] tmp = new int[seats.length];
        int count = 0;
        for(int i =0;i<seats.length;i++) {
            if(seats[i] == 1) {
                count = i-0;
                tmp[0] = count;
                break;
            }
        }

        for(int i = 1; i < seats.length;i++) {
            if(seats[i] == 1) {
                count = 0;
            }else {
                count ++;
            }
            tmp[i] = count;
        }
        count = tmp[seats.length-1];
        for(int i = seats.length-1;i>=0;i--){
            if(seats[i] == 1) {
                count = 0;
            }else {
                count ++;
            }
            tmp[i] = Math.min(count, tmp[i]);
        }

        int max = 0;
        for(int i = 0;i<seats.length;i++) {
            if(tmp[i]>max) {
                max = tmp[i];
            }
        }
        return max;
    }
}
// @lc code=end

