/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start

import java.util.*;
class Solution {
    public List<Integer> grayCode(int n) {
        return Solution89.grayCode(n);
    }
}
class Solution89{
    public static List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int tmp = 1;
        for(int i = 0; i<n ;i++) {
            List<Integer> next = new ArrayList<>(ans.size()*2);
            next.addAll(ans);
            for(int c = ans.size() -1; c>=0;c--) {
                next.add(ans.get(c) + tmp);
            }
            tmp*=2;
            ans = next;
        }
        return ans;
    }
}
// @lc code=end

