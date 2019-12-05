/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        return So1109.corpFlightBookings(bookings, n);
    }
}
class So1109{
    public static void main(String[] args) {
        System.out.println("yo");
    }
    // 20000
    // 这个就好大了的。
    // 太慢了的呀。是n*m的了。
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        // 我果然就是个zz的。
        int[] air = new int[n];
        for(int[] booking: bookings ){
            for(int i = booking[0];i<=booking[1];i++) {
                air[i-1] += booking[2];
            }
        }
        return air;
    }
}
// @lc code=end

