/*
 * @lc app=leetcode.cn id=923 lang=java
 *
 * [923] 三数之和的多种可能
 */

 import java.util.*;
// @lc code=start
class Solution {
    public int threeSumMulti(int[] A, int target) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i: A) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        Long ans = 0L;
        Integer[] keys =  map.keySet().toArray(new Integer[map.size()]);

        for(int i = 0; i<keys.length; i++) {
            for(int j = i; j<keys.length;j++) {
                Long tmp = 0L;
                int a = keys[i];
                int b = keys[j];
                int c = target - a - b ;
                if(c<0) break;
                if(c<a || c<b || !map.containsKey(c)) continue;
                if(a == b && b == c) {
                    int count = map.get(a);
                    if(count< 3) continue;
                    tmp = (long)(count-2) * (count -1) * count / 6;
                }else if( a == b) {
                    int count = map.get(b);
                    if( count < 2) continue;
                    tmp = (long)map.get(c) * count * (count -1) / 2;
                }else if( b == c) {
                    int count = map.get(b);
                    if( count < 2) continue;
                    tmp = (long)map.get(a) * count * (count -1) / 2;
                }else {
                    tmp = (long)map.get(a) * map.get(b) * map.get(c);
                }
                ans += tmp;
            }
        }
        int mode = 1_000_000_007;
        ans = ans % mode;
        return ans.intValue();
    }
}
// @lc code=end

