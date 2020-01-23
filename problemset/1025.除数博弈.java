/*
 * @lc app=leetcode.cn id=1025 lang=java
 *
 * [1025] 除数博弈
 */

// @lc code=start
import java.util.*;
class Solution {

    Boolean[] tag;
    public boolean divisorGame(int N) {
        if(N==2) return true;
        if(N==1) return false;
        tag = new Boolean[N+1];
        Arrays.fill(tag, null);
        tag[1] = false;
        tag[2] = true;
        return help(N);
    }

    public boolean help(int n) {
        if(tag[n] != null) return tag[n];
        boolean mm = false;
        for(int i=1;i<n && !mm;i++) {
            if(n%i == 0) {
                mm = mm || !help(n-1);
            }
        }
        tag[n] = mm;
        return mm;
    }
}
// @lc code=end

