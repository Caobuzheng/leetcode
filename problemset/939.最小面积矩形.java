/*
 * @lc app=leetcode.cn id=939 lang=java
 *
 * [939] 最小面积矩形
 */

import java.util.*;
// @lc code=start
class Solution {
    public int minAreaRect(int[][] points) {
        return So939.minAreaRect(points);
    }
}
class So939 {
    public static void main(String[] args) {
        int[][] points ={{1,1},{1,3},{3,1},{3,3},{2,2}};
        System.out.println(minAreaRect(points));
    }
    public static int minAreaRect(int[][] points) {
        // 其实不用MAP也行。
        Map<Integer, Set<Integer>>  map = new HashMap<>();
        Map<Integer, Set<Integer>>  map2 = new HashMap<>();
        int max = Integer.MAX_VALUE;

        for(int[] point: points) {
            int x = point[0];
            int y = point[1];
            if(!map.containsKey(x)) {
                map.put(x, new HashSet<>());
            }
            if(!map2.containsKey(y)){
                map2.put(y, new HashSet<>());
            }
            map.get(x).add(y);
            map2.get(y).add(x);
            for(int y2: map.get(x)) {
                // 还可以优化下。
                // 这里似乎是没必要的呀。
                for(int x2: map2.get(y)){
                    if(x!=x2 && y!=y2 && map.get(x).contains(y2) && map.get(x2).contains(y) && map.get(x2).contains(y2)) {
                            int area = Math.abs(x2 - x) * Math.abs(y2-y);
                            max = Math.min(area, max); 
                        }
                }
            }
        }
        return max==Integer.MAX_VALUE?0:max;
    }
}
// @lc code=end

