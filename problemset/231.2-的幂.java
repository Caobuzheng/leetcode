/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        return Solution231.isPowerOfTwo(n);
    }
}
class Solution231 {

    public static void main(String[] args) {
        int ans = 2;
        for(int i = 1; i<=29;i++) {
            ans *=2;
        }
        System.out.println(ans);
    }

    public static boolean isPowerOfTwo(int n) {
        return n<=0?false:n==1?true:1073741824%n == 0;
    }
}
// @lc code=end

