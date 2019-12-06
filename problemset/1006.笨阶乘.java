/*
 * @lc app=leetcode.cn id=1006 lang=java
 *
 * [1006] 笨阶乘
 */

// @lc code=start
class Solution {
    public int clumsy(int N) {
        int more = 0;
        int tag = 1;
        int n = N;
        
        while(n>=4){
            more +=(n*(n-1)/(n-2) * tag + n -3);
            n-=4;
            tag=-1;
        }
        if(n ==3) {
            more += 6 * tag;
        }else  more += n*tag;
        return more;
    }
}
// @lc code=end

