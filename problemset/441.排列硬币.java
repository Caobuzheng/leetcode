/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        int l = 0;
        int r = n;
        while(l<=r){
            int mid = (l+r)/2;// 可能会溢出。不会的啦。
            if(sum(mid) <= n && sum(mid+1) > n) return mid;
            if(sum(mid) < n) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return 0;
    }
    long sum(int n) {
        return (long)(1+n) * n / 2;
    }
}
// @lc code=end

