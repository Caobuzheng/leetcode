/*
 * @lc app=leetcode.cn id=476 lang=java
 *
 * [476] 数字的补数
 */

// @lc code=start
class Solution {
    public int findComplement(int num) {
        // 这个地方，防不胜防。
        if(num == 0) return 1;
        int[] n = new int[32];
        int index = 0;
        while(num>0) {
            if(num % 2==0) {
                n[index] = 1;
            }else {
                n[index] = 0;
            }
            index++;
            num/=2;
        }       
        int ans = 0;
        int more = 1;
        for(int i = 0;i<32;i++) {
            ans += n[i] * more;
            more *= 2;
        }
        return ans;
    }
}
// @lc code=end

