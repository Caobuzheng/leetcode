/*
 * @lc app=leetcode.cn id=686 lang=java
 *
 * [686] 重复叠加字符串匹配
 */

// @lc code=start
import java.util.*;
class Solution {
    public int repeatedStringMatch(String A, String B) {
        return Solution686.repeatedStringMatch(A, B);
    }
}
class Solution686 {

    public static int repeatedStringMatch(String A, String B) {
        String tmp = A;
        int count = 1;
        while(tmp.length() <= A.length() *2 + B.length() ) {
            int idx = tmp.indexOf(B);
            if(idx>=0) return count;
            count++;
            tmp = tmp + A;
        } 
        return -1;
    }
}
// @lc code=end

